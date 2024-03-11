package com.example.encyption_app;

import java.math.BigInteger;
import com.example.encyption_app.HardActivity;

public class RsaCipher {
//    int prime1=Integer.parseInt(HardActivity.prime1.getText().toString());
//    int prime2=Integer.parseInt(HardActivity.prime2.getText().toString());
//    int p,q,n,t,flag;
//    int i,j;
//    int []e=new int[100];
//    int []d=new int[100];
//    int []temp=new int[100];
//    int []m=new int[100];
//    int []en=new int[100];
//    char []c=new char[100];
//
//    public char [] stringToChar(String msg)
//    {
//        for (int i=0;i<msg.length();i++)
//        {
//            m[i]=msg.charAt(i);
//        }
//        return m;
//    }
//
//    public int prime(int num)
//    {
//        int i=0;
//        if(num==1)
//            return 0;
//        for (i=2;i<=Math.sqrt(num);i++)
//        {
//            if(num%i==0)
//            {
//                return 0;
//            }
//        }
//        return 1;
//    }
//
//    public void ce()
//    {
//        int k=0;
//        for (int i=2;i<t;i++)
//        {
//            if(t%i==0)
//            {
//                continue;
//            }
//            flag=prime(i);
//            if(flag==1 && i!=p &&i!=q)
//            {
//                e[k]=i;
//                flag=cd(e[k]);
//                if(flag>0)
//                {
//                    d[k]=flag;
//                    k++;
//                }
//                if(k==9)
//                {
//                    break;
//                }
//            }
//        }
//
//    }
//
//    public int cd(int x)
//    {
//        int k=1;
//        while (true)
//        {
//            k=k+t;
//            if(k%x==0)
//            {
//                return (k/x);
//            }
//        }
//    }
//
//    public void encrypt()
//    {
//        int pt,ct,k,len;
//        int key=e[0];
//        int i=0;
//        len=msg.length();
//        String ans="";
//        while (i<len)
//        {
//            pt=m[i];
//            pt=pt-96;
//            k=1;
//            for (j=0;j<key;j++)
//            {
//                k=k*pt;
//                k=k%n;
//            }
//            temp[i]=k;
//            ct=k+96;
//            en[i]=ct;
//            i++;
//        }
//        en[i]=-1;
//        char ch;
//        for (i=0;en[i]!=-1;i++)
//        {
//            ch=(char) en[i];
//            ans=ans+ch;
//        }
//    }
//
//    public void decrypt()
//    {
//        int pt,ct,k;
//        int key=d[0];
//        int i=0;
//        String ans="";
//        while (en[i]!=-1)
//        {
//            ct=temp[i];
//            k=1;
//            for (j=0;j<key;j++)
//            {
//                k=k*ct;
//                k=k%n;
//            }
//            pt=k+96;
//            m[i]=pt;
//            i++;
//        }
//        m[i]=-1;
//        char ch;
//        for (i=0;m[i]!=-1;i++)
//        {
//            ch=(char)m[i];
//            ans=ans+ch;
//        }
//    }

    public int p;
    public int q;
    public int n;
    public int e;
    public int d;

    public RsaCipher(int p, int q, int e) {
        this.p = p;
        this.q = q;
        this.n = p * q;
        this.e = e;
        this.d = this.calculatePrivateKey();
    }

    public int calculatePrivateKey() {
        int phi = (p - 1) * (q - 1);
        BigInteger eBigInteger = BigInteger.valueOf(e);
        BigInteger phiBigInteger = BigInteger.valueOf(phi);
        BigInteger dBigInteger = eBigInteger.modInverse(phiBigInteger);
        return dBigInteger.intValue();
    }

    public String encrypt(String message) {
        StringBuilder ciphertextBuilder = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            BigInteger m = BigInteger.valueOf((int) c);
            BigInteger encrypted = m.modPow(BigInteger.valueOf(e), BigInteger.valueOf(n));
            ciphertextBuilder.append(encrypted).append(" ");
        }
        return ciphertextBuilder.toString();
    }

    public String decrypt(String ciphertext) {
        StringBuilder plaintextBuilder = new StringBuilder();
        String[] encryptedChars = ciphertext.split(" ");
        for (String encryptedChar : encryptedChars) {
            BigInteger encrypted = new BigInteger(encryptedChar);
            BigInteger decrypted = encrypted.modPow(BigInteger.valueOf(d), BigInteger.valueOf(n));
            char plaintextChar = (char) decrypted.intValue();
            plaintextBuilder.append(plaintextChar);
        }
        return plaintextBuilder.toString();
    }
    public String toAsciiString(String message) {
        StringBuilder sb = new StringBuilder();
        for (char c : message.toCharArray()) {
            int asciiCode = (int) c;
            sb.append(asciiCode);
        }
        return sb.toString();
    }

    public void setP(int p) {
        this.p = p;
    }

    public void setQ(int q) {
        this.q = q;
    }
}
