import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

// �ͻ���
public class UDPSenderB {
    public static void main(String[] args) throws Exception {
        // 1. ���� DatagramSocket ����׼���� 9998 �˿� ��������
        DatagramSocket socket = new DatagramSocket(9998);

        // 2. ����Ҫ���͵����ݣ���װ�� DatagramPacket ����
        byte[] data = "hello ����Ի��~".getBytes();
        // ˵��: ��װ�� DatagramPacket ���� data �����ֽ�����, data.length , ����(IP) , �˿�
        DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getByName("192.168.111.1"), 9999);
        socket.send(packet);

        // 3. ���մ� A �˻ظ�����Ϣ
        // (1) ����һ�� DatagramPacket ����׼����������
        // ��ǰ�潲�� UDP Э��ʱ����ʦ˵��һ�����ݰ���� 64k
        byte[] buf = new byte[1024];
        packet = new DatagramPacket(buf, buf.length);
        // (2) ���� ���շ���, ��ͨ�����紫��� DatagramPacket ������䵽 packet ����
        // ��ʦ��ʾ: �������ݰ����͵� ������ 9998 �˿�ʱ���ͻ���յ�����
        // ���û�����ݰ����͵� ������ 9998 �˿�, �ͻ������ȴ�.
        socket.receive(packet);

        // (3) ���԰� packet ���в����ȡ�����ݣ�����ʾ.
        int length = packet.getLength();//ʵ�ʽ��յ��������ֽڳ���
        data = packet.getData();//���յ�����
        String s = new String(data, 0, length);
        System.out.println(s);

        // �ر���Դ
        socket.close();
        System.out.println("B ���˳�");
    }
}