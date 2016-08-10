import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Arrays;
import java.util.Enumeration;

public class IdHelper
{

  public static void main(String[] args) throws SocketException
  {
    Enumeration<NetworkInterface> nis = NetworkInterface.getNetworkInterfaces();
    byte[] macSum = new byte[] { 0, 0, 0, 0, 0, 0 };
    while (nis.hasMoreElements())
    {
      NetworkInterface ni = nis.nextElement();
      byte[] mac = ni.getHardwareAddress();
      if ((mac != null) && (mac.length >= 6))
      {
        macSum[0] = (byte) ((macSum[0] + mac[0]) % 256);
        macSum[1] = (byte) ((macSum[1] + mac[1]) % 256);
        macSum[2] = (byte) ((macSum[2] + mac[2]) % 256);
        macSum[3] = (byte) ((macSum[3] + mac[3]) % 256);
        macSum[4] = (byte) ((macSum[4] + mac[4]) % 256);
        macSum[5] = (byte) ((macSum[5] + mac[5]) % 256);
      }
    }
    System.out.print(Integer.toHexString(Arrays.hashCode(macSum)));
  }

}
