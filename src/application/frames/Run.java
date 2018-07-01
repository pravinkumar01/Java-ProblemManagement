package application.frames;

public class Run {

	public static void main(String[] args) throws Exception {
		try{
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }

			java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	            	LoginWindow objLoginWindow = new LoginWindow();
	            	objLoginWindow.setVisible(true);
	            }
	        });
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
