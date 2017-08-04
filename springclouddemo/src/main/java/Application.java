import com.jcraft.jsch.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by searover on 16/06/2017.
 */
public class Application {

    public static void main(String[] args) throws JSchException, IOException {
        String username = "root";
        String password = "Pp.51idc.com";
        String hostname = "192.168.201.100";
        int port = 22;

        JSch jSch = new JSch();
        Session session = jSch.getSession(username, hostname, port);
        session.setPassword(password);
        session.setConfig("StrictHostKeyChecking","no");
        session.connect();
        String sshCmd = "uname -a";
        Channel channel = session.openChannel("exec");
        ((ChannelExec)channel).setCommand(sshCmd);
        channel.setInputStream(null);
        InputStream in = channel.getInputStream();
        channel.connect();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line = null;
        while ((line = reader.readLine()) != null){
            System.out.println(line);
        }
        channel.disconnect();
        session.disconnect();
    }
}
