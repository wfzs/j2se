package socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TestSocket {
	public static void main(String[] args) throws UnknownHostException, InterruptedException {
		InetAddress host=InetAddress.getLocalHost();
		String ip=host.getHostAddress();
		String ipRange=ip.substring(0, ip.lastIndexOf("."));
		System.out.println("本机IP地址："+ip);
		System.out.println("网段是："+ipRange);
		
		List<String> ips=Collections.synchronizedList(new ArrayList<>());
		ThreadPoolExecutor threadPool=new ThreadPoolExecutor(10,15,60,TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>());
		AtomicInteger number=new AtomicInteger();
		
		for(int i=0;i<255;i++){
			String testIp=ipRange+"."+(i+1);
			threadPool.execute(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					boolean f=isReachable(testIp);
					if(f)
						ips.add(testIp);
					synchronized(number){
						System.out.println("已经完成"+number.incrementAndGet()+"个ip测试");
					}
				}				
				
			});
		}
		threadPool.shutdown();
		if(threadPool.awaitTermination(1, TimeUnit.HOURS)){
			 System.out.println("如下ip地址可以连接");
	            for (String theip : ips) {
	                System.out.println(theip);
	            }
	            System.out.println("总共有:" + ips.size() + " 个地址");
		}
	}

	protected static boolean isReachable(String testIp) {
		// TODO Auto-generated method stub
		try {
			boolean f=false;
			Process p=Runtime.getRuntime().exec("ping "+testIp);
			BufferedReader br=new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line=null;
			StringBuilder sb=new StringBuilder();
			while((line=br.readLine())!=null){
				if(line.length()!=0)
					sb.append(line);
			}
			f=sb.toString().contains("TTL");
			br.close();
			return f;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}	
}
