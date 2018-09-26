package webserv;

import com.tc.utils.utilities.io.HttpConn;
import com.tc.utils.utilities.io.HttpMethod;

import totalcross.ui.*;
import totalcross.ui.dialog.MessageBox;
import totalcross.io.*;
public class WebServ extends MainWindow {


	public void initUI(){

		ScrollContainer sc = new ScrollContainer(true,false){
			public void initUI(){
				try{
					HttpConn conn = new HttpConn("http://www.ouvevoce.net/AppCode/email.php?para=mauro@quasarproducoes.com.br&assunto=Teste+de+email_2&mensagem=Corpo+da+mensagem_2");

					conn.setHttpMethod(HttpMethod.GET);
					conn.getContentEncoding();
					conn.setContentType("text/plain");
					Stream result = conn.connect();


					String msgCode = null;
					byte[] bytes = new byte[1024];
					int bytesRead = result.readBytes(bytes, 0, bytes.length);

					if(bytesRead > 0){
						msgCode = new String(bytes,0,bytesRead);
					}



					Label lg = new Label(msgCode);
					add(lg,LEFT+20,AFTER+20);
					
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		};
		add(sc,LEFT,TOP,FILL,FILL);
	}
}