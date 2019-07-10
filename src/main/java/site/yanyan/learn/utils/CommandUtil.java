package site.yanyan.learn.utils;

import java.io.*;
import java.sql.Timestamp;

public class CommandUtil {
	/**
	 * @param name 命令
	 * @param command
	 * @param path 保存文件路径
	 * @return excuteStartTime执行开始时间
	 */
	public Timestamp run(String name, String command, String path) {
		Sender sender = new Sender();
		Recive recive = new Recive();
		PipedOutputStream po = sender.getPipedOutputStream(command);
		PipedInputStream pi = recive.getPipedInputStream(path, name);
		try {
			pi.connect(po);
		} catch (IOException e) {
			e.printStackTrace();
		}
		new Thread(sender).start();
		new Thread(recive).start();
		return new Timestamp(System.currentTimeMillis());
	}

	public Long getPID(String exeName) {
		String pid = null;
		try {
//			String cmd = "tasklist /nh /FI \"IMAGENAME eq " + exeName + "\"";
			String cmd = "tasklist /nh /FI \"IMAGENAME eq STS.exe\"";
			Runtime runtime = Runtime.getRuntime();
			Process process = runtime.exec(cmd);
			BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line = null;
			while((line=br.readLine()) != null){
//				if(line.indexOf(exeName) != -1){
				if(line.indexOf("STS.exe") != -1){
					String[] lineArray = line.split(" ");
					for (int i = 1; i < lineArray.length; i++) {
						if(lineArray[i].isEmpty() == false) {
							pid = lineArray[i];
							break;
						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(pid);
		if(pid == null) {
			return null;
		}
		return Long.parseLong(pid);
	}
	
	class Sender implements Runnable{
		
		private String command;
		PipedOutputStream out = null;
		 
		public PipedOutputStream getPipedOutputStream(String command) {
			this.command = command;
			out = new PipedOutputStream();
			return out;
		}
		
		@Override
		public void run() {
			try {
		 		String cmd = "cmd /c \"" + command + " \"";
		        Runtime runtime = Runtime.getRuntime();  
		        Process process = runtime.exec(cmd);  
		        InputStream is = process.getInputStream();  
		        InputStreamReader isr = new InputStreamReader(is, "gbk"); //gbk：解决输出乱码  
		        BufferedReader br = new BufferedReader(isr);  
		        String line;
		        while ((line = br.readLine()) != null){ 
		        	out.write(line.getBytes());
		            out.flush();
		            Thread.sleep(100);                 
		            }
		        is.close();
		        isr.close();
		        br.close();
		        out.close();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		}
		
	}
	
	class Recive implements Runnable{

		private String path;
		private String name;
		PipedInputStream in = null;
	    
	    public PipedInputStream getPipedInputStream(String path, String name) {
	    	this.path = path;
	    	this.name = name;
	        in = new PipedInputStream();
	        return in;
	    }
	    @Override
	    public void run() {
	        byte[] bys = new byte[1024];
	        try {
	        	FileOutputStream fileOutputStream = new FileOutputStream(
	        			new File(path), true);
	        	BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
	        	bufferedOutputStream.write(("[" + name + "]" + System.getProperty("line.separator")).getBytes());
	            while(in.read(bys) != -1) {
	                String str = new String(bys).trim();
	                System.out.println(str);
	                bufferedOutputStream.write((str + System.getProperty("line.separator")).getBytes());
	            }
	            bufferedOutputStream.close();
	            fileOutputStream.close();
	            in.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
		
	}
}