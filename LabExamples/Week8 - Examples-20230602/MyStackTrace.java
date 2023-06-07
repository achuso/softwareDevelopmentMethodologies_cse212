public class MyStackTrace {
	
    public static void main(String[] argv) throws Exception {
    	
        try {
        	
            int x = 1, y = 0;
            System.out.println(x / y);
            
        } catch (Throwable e) {
        	
            StackTraceElement stack[] = e.getStackTrace();

            for (int i = 0; i < stack.length; i++) {
            	
                String filename = stack[i].getFileName();
                
                if (filename == null) {
                    System.out.println("filename is not available");
                }
                
                
                
                String className = stack[i].getClassName();
                System.out.println("Class name is "+className);
                
                String methodName = stack[i].getMethodName();
                System.out.println("Method name is "+methodName);
                
                boolean isNativeMethod = stack[i].isNativeMethod();
                System.out.println(isNativeMethod);
                
                int line = stack[i].getLineNumber();
                System.out.println("line number is "+line);
            }
        }
    }
}