package com.example.gits.jgit;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import org.eclipse.jgit.api.TransportConfigCallback;
import org.eclipse.jgit.transport.*;
import org.eclipse.jgit.util.FS;
import org.springframework.util.ResourceUtils;

public class SshTransportConfigCallback implements TransportConfigCallback {

    public static final SshTransportConfigCallback INSTANCE = new SshTransportConfigCallback();
    private final SshSessionFactory sshSessionFactory = new JschConfigSessionFactory() {

        @Override

        protected void configure(OpenSshConfig.Host hc, Session session) {

            session.setConfig("StrictHostKeyChecking", "no");

        }

        @Override

        protected JSch createDefaultJSch(FS fs) throws JSchException {

            try {
                JSch jSch = super.createDefaultJSch(fs);

              //  jSch.addIdentity("E:\\rn\\gs-gateway-master\\pjgit\\src\\main\\resources\\ssh\\id_rsa", "123456".getBytes());

                /*FastByteArrayOutputStream prvkey = new FastByteArrayOutputStream();
                FastByteArrayOutputStream pubKey = new FastByteArrayOutputStream();
                FileCopyUtils.copy(new FileInputStream(ResourceUtils.getFile("classpath:ssh/id_rsa")), prvkey);
                FileCopyUtils.copy(new FileInputStream(ResourceUtils.getFile("classpath:ssh/id_rsa.pub")), pubKey);
                jSch.addIdentity("github",prvkey.toByteArray(),pubKey.toByteArray(),"123456".getBytes());*/
                jSch.addIdentity(ResourceUtils.getFile("classpath:ssh/id_rsa").getAbsolutePath(), "123456".getBytes());
                return jSch;
            } catch (Exception e) {
                throw new JSchException(e.getMessage(), e);
            }

        }

    };

    public void configure(Transport transport) {
        SshTransport sshTransport = (SshTransport) transport;

        sshTransport.setSshSessionFactory(sshSessionFactory);
    }


}
