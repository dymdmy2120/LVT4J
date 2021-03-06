package com.lvt4j.office;

import java.lang.reflect.Field;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.lvt4j.basic.TReflect;

public class TWeb {
    
    public static final String DefaultContentType = "application/octet-stream";
    
    private static final Map<String, String> contentTypes = new HashMap<String, String>();
    static{
        contentTypes.put("001", "application/x-001");
        contentTypes.put("323", "text/h323");
        contentTypes.put("907", "drawing/907");
        contentTypes.put("acp", "audio/x-mei-aac");
        contentTypes.put("aif", "audio/aiff");
        contentTypes.put("aiff", "audio/aiff");
        contentTypes.put("asa", "text/asa");
        contentTypes.put("asp", "text/asp");
        contentTypes.put("au", "audio/basic");
        contentTypes.put("awf", "application/vnd.adobe.workflow");
        contentTypes.put("bmp", "application/x-bmp");
        contentTypes.put("c4t", "application/x-c4t");
        contentTypes.put("cal", "application/x-cals");
        contentTypes.put("cdf", "application/x-netcdf");
        contentTypes.put("cel", "application/x-cel");
        contentTypes.put("cg4", "application/x-g4");
        contentTypes.put("cit", "application/x-cit");
        contentTypes.put("cml", "text/xml");
        contentTypes.put("cmx", "application/x-cmx");
        contentTypes.put("crl", "application/pkix-crl");
        contentTypes.put("csi", "application/x-csi");
        contentTypes.put("cut", "application/x-cut");
        contentTypes.put("dbm", "application/x-dbm");
        contentTypes.put("dcd", "text/xml");
        contentTypes.put("der", "application/x-x509-ca-cert");
        contentTypes.put("dib", "application/x-dib");
        contentTypes.put("doc", "application/msword");
        contentTypes.put("drw", "application/x-drw");
        contentTypes.put("dwf", "Model/vnd.dwf");
        contentTypes.put("dwg", "application/x-dwg");
        contentTypes.put("dxf", "application/x-dxf");
        contentTypes.put("emf", "application/x-emf");
        contentTypes.put("ent", "text/xml");
        contentTypes.put("eps", "application/x-ps");
        contentTypes.put("etd", "application/x-ebx");
        contentTypes.put("fax", "image/fax");
        contentTypes.put("fif", "application/fractals");
        contentTypes.put("frm", "application/x-frm");
        contentTypes.put("gbr", "application/x-gbr");
        contentTypes.put("gif", "image/gif");
        contentTypes.put("gp4", "application/x-gp4");
        contentTypes.put("hmr", "application/x-hmr");
        contentTypes.put("hpl", "application/x-hpl");
        contentTypes.put("hrf", "application/x-hrf");
        contentTypes.put("htc", "text/x-component");
        contentTypes.put("html", "text/html");
        contentTypes.put("htx", "text/html");
        contentTypes.put("ico", "image/x-icon");
        contentTypes.put("iff", "application/x-iff");
        contentTypes.put("igs", "application/x-igs");
        contentTypes.put("img", "application/x-img");
        contentTypes.put("isp", "application/x-internet-signup");
        contentTypes.put("java", "java/*");
        contentTypes.put("jpe", "image/jpeg");
        contentTypes.put("jpeg", "image/jpeg");
        contentTypes.put("jpg", "application/x-jpg");
        contentTypes.put("jsp", "text/html");
        contentTypes.put("lar", "application/x-laplayer-reg");
        contentTypes.put("lavs", "audio/x-liquid-secure");
        contentTypes.put("lmsff", "audio/x-la-lms");
        contentTypes.put("ltr", "application/x-ltr");
        contentTypes.put("m2v", "video/x-mpeg");
        contentTypes.put("m4e", "video/mpeg4");
        contentTypes.put("man", "application/x-troff-man");
        contentTypes.put("mdb", "application/msaccess");
        contentTypes.put("mfp", "application/x-shockwave-flash");
        contentTypes.put("mhtml", "message/rfc822");
        contentTypes.put("mid", "audio/mid");
        contentTypes.put("mil", "application/x-mil");
        contentTypes.put("mnd", "audio/x-musicnet-download");
        contentTypes.put("mocha", "application/x-javascript");
        contentTypes.put("mp1", "audio/mp1");
        contentTypes.put("mp2v", "video/mpeg");
        contentTypes.put("mp4", "video/mpeg4");
        contentTypes.put("mpd", "application/vnd.ms-project");
        contentTypes.put("mpeg", "video/mpg");
        contentTypes.put("mpga", "audio/rn-mpeg");
        contentTypes.put("mps", "video/x-mpeg");
        contentTypes.put("mpv", "video/mpg");
        contentTypes.put("mpw", "application/vnd.ms-project");
        contentTypes.put("mtx", "text/xml");
        contentTypes.put("net", "image/pnetvue");
        contentTypes.put("nws", "message/rfc822");
        contentTypes.put("out", "application/x-out");
        contentTypes.put("p12", "application/x-pkcs12");
        contentTypes.put("p7c", "application/pkcs7-mime");
        contentTypes.put("p7r", "application/x-pkcs7-certreqresp");
        contentTypes.put("pc5", "application/x-pc5");
        contentTypes.put("pcl", "application/x-pcl");
        contentTypes.put("pdf", "application/pdf");
        contentTypes.put("pdx", "application/vnd.adobe.pdx");
        contentTypes.put("pgl", "application/x-pgl");
        contentTypes.put("pko", "application/vnd.ms-pki.pko");
        contentTypes.put("plg", "text/html");
        contentTypes.put("plt", "application/x-plt");
        contentTypes.put("png", "application/x-png");
        contentTypes.put("ppa", "application/vnd.ms-powerpoint");
        contentTypes.put("pps", "application/vnd.ms-powerpoint");
        contentTypes.put("ppt", "application/x-ppt");
        contentTypes.put("prf", "application/pics-rules");
        contentTypes.put("prt", "application/x-prt");
        contentTypes.put("ps", "application/postscript");
        contentTypes.put("pwz", "application/vnd.ms-powerpoint");
        contentTypes.put("ra", "audio/vnd.rn-realaudio");
        contentTypes.put("ras", "application/x-ras");
        contentTypes.put("rdf", "text/xml");
        contentTypes.put("red", "application/x-red");
        contentTypes.put("rjs", "application/vnd.rn-realsystem-rjs");
        contentTypes.put("rlc", "application/x-rlc");
        contentTypes.put("rm", "application/vnd.rn-realmedia");
        contentTypes.put("rmi", "audio/mid");
        contentTypes.put("rmm", "audio/x-pn-realaudio");
        contentTypes.put("rms", "application/vnd.rn-realmedia-secure");
        contentTypes.put("rmx", "application/vnd.rn-realsystem-rmx");
        contentTypes.put("rp", "image/vnd.rn-realpix");
        contentTypes.put("rsml", "application/vnd.rn-rsml");
        contentTypes.put("rtf", "application/msword");
        contentTypes.put("rv", "video/vnd.rn-realvideo");
        contentTypes.put("sat", "application/x-sat");
        contentTypes.put("sdw", "application/x-sdw");
        contentTypes.put("slb", "application/x-slb");
        contentTypes.put("slk", "drawing/x-slk");
        contentTypes.put("smil", "application/smil");
        contentTypes.put("snd", "audio/basic");
        contentTypes.put("sor", "text/plain");
        contentTypes.put("spl", "application/futuresplash");
        contentTypes.put("ssm", "application/streamingmedia");
        contentTypes.put("stl", "application/vnd.ms-pki.stl");
        contentTypes.put("sty", "application/x-sty");
        contentTypes.put("swf", "application/x-shockwave-flash");
        contentTypes.put("tg4", "application/x-tg4");
        contentTypes.put("tif", "image/tiff");
        contentTypes.put("tiff", "image/tiff");
        contentTypes.put("top", "drawing/x-top");
        contentTypes.put("tsd", "text/xml");
        contentTypes.put("uin", "application/x-icq");
        contentTypes.put("vcf", "text/x-vcard");
        contentTypes.put("vdx", "application/vnd.visio");
        contentTypes.put("vpg", "application/x-vpeg005");
        contentTypes.put("vsd", "application/x-vsd");
        contentTypes.put("vst", "application/vnd.visio");
        contentTypes.put("vsw", "application/vnd.visio");
        contentTypes.put("vtx", "application/vnd.visio");
        contentTypes.put("wav", "audio/wav");
        contentTypes.put("wb1", "application/x-wb1");
        contentTypes.put("wb3", "application/x-wb3");
        contentTypes.put("wiz", "application/msword");
        contentTypes.put("wk4", "application/x-wk4");
        contentTypes.put("wks", "application/x-wks");
        contentTypes.put("wma", "audio/x-ms-wma");
        contentTypes.put("wmf", "application/x-wmf");
        contentTypes.put("wmv", "video/x-ms-wmv");
        contentTypes.put("wmz", "application/x-ms-wmz");
        contentTypes.put("wpd", "application/x-wpd");
        contentTypes.put("wpl", "application/vnd.ms-wpl");
        contentTypes.put("wr1", "application/x-wr1");
        contentTypes.put("wrk", "application/x-wrk");
        contentTypes.put("ws2", "application/x-ws");
        contentTypes.put("wsdl", "text/xml");
        contentTypes.put("xdp", "application/vnd.adobe.xdp");
        contentTypes.put("xfd", "application/vnd.adobe.xfd");
        contentTypes.put("xhtml", "text/html");
        contentTypes.put("xls", "application/x-xls");
        contentTypes.put("xml", "text/xml");
        contentTypes.put("xq", "text/xml");
        contentTypes.put("xquery", "text/xml");
        contentTypes.put("xsl", "text/xml");
        contentTypes.put("xwd", "application/x-xwd");
        contentTypes.put("sis", "application/vnd.symbian.install");
        contentTypes.put("x_t", "application/x-x_t");
        contentTypes.put("apk", "application/vnd.android.package-archive");
        contentTypes.put("tif", "image/tiff");
        contentTypes.put("301", "application/x-301");
        contentTypes.put("906", "application/x-906");
        contentTypes.put("a11", "application/x-a11");
        contentTypes.put("ai", "application/postscript");
        contentTypes.put("aifc", "audio/aiff");
        contentTypes.put("anv", "application/x-anv");
        contentTypes.put("asf", "video/x-ms-asf");
        contentTypes.put("asx", "video/x-ms-asf");
        contentTypes.put("avi", "video/avi");
        contentTypes.put("biz", "text/xml");
        contentTypes.put("bot", "application/x-bot");
        contentTypes.put("c90", "application/x-c90");
        contentTypes.put("cat", "application/vnd.ms-pki.seccat");
        contentTypes.put("cdr", "application/x-cdr");
        contentTypes.put("cer", "application/x-x509-ca-cert");
        contentTypes.put("cgm", "application/x-cgm");
        contentTypes.put("class", "java/*");
        contentTypes.put("cmp", "application/x-cmp");
        contentTypes.put("cot", "application/x-cot");
        contentTypes.put("crt", "application/x-x509-ca-cert");
        contentTypes.put("css", "text/css");
        contentTypes.put("dbf", "application/x-dbf");
        contentTypes.put("dbx", "application/x-dbx");
        contentTypes.put("dcx", "application/x-dcx");
        contentTypes.put("dgn", "application/x-dgn");
        contentTypes.put("dll", "application/x-msdownload");
        contentTypes.put("dot", "application/msword");
        contentTypes.put("dtd", "text/xml");
        contentTypes.put("dwf", "application/x-dwf");
        contentTypes.put("dxb", "application/x-dxb");
        contentTypes.put("edn", "application/vnd.adobe.edn");
        contentTypes.put("eml", "message/rfc822");
        contentTypes.put("epi", "application/x-epi");
        contentTypes.put("eps", "application/postscript");
        contentTypes.put("exe", "application/x-msdownload");
        contentTypes.put("fdf", "application/vnd.fdf");
        contentTypes.put("fo", "text/xml");
        contentTypes.put("g4", "application/x-g4");
        contentTypes.put("", "application/x-");
        contentTypes.put("gl2", "application/x-gl2");
        contentTypes.put("hgl", "application/x-hgl");
        contentTypes.put("hpg", "application/x-hpgl");
        contentTypes.put("hqx", "application/mac-binhex40");
        contentTypes.put("hta", "application/hta");
        contentTypes.put("htm", "text/html");
        contentTypes.put("htt", "text/webviewhtml");
        contentTypes.put("icb", "application/x-icb");
        contentTypes.put("ico", "application/x-ico");
        contentTypes.put("ig4", "application/x-g4");
        contentTypes.put("iii", "application/x-iphone");
        contentTypes.put("ins", "application/x-internet-signup");
        contentTypes.put("IVF", "video/x-ivf");
        contentTypes.put("jfif", "image/jpeg");
        contentTypes.put("jpe", "application/x-jpe");
        contentTypes.put("jpg", "image/jpeg");
        contentTypes.put("js", "application/x-javascript");
        contentTypes.put("la1", "audio/x-liquid-file");
        contentTypes.put("latex", "application/x-latex");
        contentTypes.put("lbm", "application/x-lbm");
        contentTypes.put("ls", "application/x-javascript");
        contentTypes.put("m1v", "video/x-mpeg");
        contentTypes.put("m3u", "audio/mpegurl");
        contentTypes.put("mac", "application/x-mac");
        contentTypes.put("math", "text/xml");
        contentTypes.put("mdb", "application/x-mdb");
        contentTypes.put("mht", "message/rfc822");
        contentTypes.put("mi", "application/x-mi");
        contentTypes.put("midi", "audio/mid");
        contentTypes.put("mml", "text/xml");
        contentTypes.put("mns", "audio/x-musicnet-stream");
        contentTypes.put("movie", "video/x-sgi-movie");
        contentTypes.put("mp2", "audio/mp2");
        contentTypes.put("mp3", "audio/mp3");
        contentTypes.put("mpa", "video/x-mpg");
        contentTypes.put("mpe", "video/x-mpeg");
        contentTypes.put("mpg", "video/mpg");
        contentTypes.put("mpp", "application/vnd.ms-project");
        contentTypes.put("mpt", "application/vnd.ms-project");
        contentTypes.put("mpv2", "video/mpeg");
        contentTypes.put("mpx", "application/vnd.ms-project");
        contentTypes.put("mxp", "application/x-mmxp");
        contentTypes.put("nrf", "application/x-nrf");
        contentTypes.put("odc", "text/x-ms-odc");
        contentTypes.put("p10", "application/pkcs10");
        contentTypes.put("p7b", "application/x-pkcs7-certificates");
        contentTypes.put("p7m", "application/pkcs7-mime");
        contentTypes.put("p7s", "application/pkcs7-signature");
        contentTypes.put("pci", "application/x-pci");
        contentTypes.put("pcx", "application/x-pcx");
        contentTypes.put("pdf", "application/pdf");
        contentTypes.put("pfx", "application/x-pkcs12");
        contentTypes.put("pic", "application/x-pic");
        contentTypes.put("pl", "application/x-perl");
        contentTypes.put("pls", "audio/scpls");
        contentTypes.put("png", "image/png");
        contentTypes.put("pot", "application/vnd.ms-powerpoint");
        contentTypes.put("ppm", "application/x-ppm");
        contentTypes.put("ppt", "application/vnd.ms-powerpoint");
        contentTypes.put("pr", "application/x-pr");
        contentTypes.put("prn", "application/x-prn");
        contentTypes.put("ps", "application/x-ps");
        contentTypes.put("ptn", "application/x-ptn");
        contentTypes.put("r3t", "text/vnd.rn-realtext3d");
        contentTypes.put("ram", "audio/x-pn-realaudio");
        contentTypes.put("rat", "application/rat-file");
        contentTypes.put("rec", "application/vnd.rn-recording");
        contentTypes.put("rgb", "application/x-rgb");
        contentTypes.put("rjt", "application/vnd.rn-realsystem-rjt");
        contentTypes.put("rle", "application/x-rle");
        contentTypes.put("rmf", "application/vnd.adobe.rmf");
        contentTypes.put("rmj", "application/vnd.rn-realsystem-rmj");
        contentTypes.put("rmp", "application/vnd.rn-rn_music_package");
        contentTypes.put("rmvb", "application/vnd.rn-realmedia-vbr");
        contentTypes.put("rnx", "application/vnd.rn-realplayer");
        contentTypes.put("rpm", "audio/x-pn-realaudio-plugin");
        contentTypes.put("rt", "text/vnd.rn-realtext");
        contentTypes.put("rtf", "application/x-rtf");
        contentTypes.put("sam", "application/x-sam");
        contentTypes.put("sdp", "application/sdp");
        contentTypes.put("sit", "application/x-stuffit");
        contentTypes.put("sld", "application/x-sld");
        contentTypes.put("smi", "application/smil");
        contentTypes.put("smk", "application/x-smk");
        contentTypes.put("sol", "text/plain");
        contentTypes.put("spc", "application/x-pkcs7-certificates");
        contentTypes.put("spp", "text/xml");
        contentTypes.put("sst", "application/vnd.ms-pki.certstore");
        contentTypes.put("stm", "text/html");
        contentTypes.put("svg", "text/xml");
        contentTypes.put("tdf", "application/x-tdf");
        contentTypes.put("tga", "application/x-tga");
        contentTypes.put("tif", "application/x-tif");
        contentTypes.put("tld", "text/xml");
        contentTypes.put("torrent", "application/x-bittorrent");
        contentTypes.put("txt", "text/plain");
        contentTypes.put("uls", "text/iuls");
        contentTypes.put("vda", "application/x-vda");
        contentTypes.put("vml", "text/xml");
        contentTypes.put("vsd", "application/vnd.visio");
        contentTypes.put("vss", "application/vnd.visio");
        contentTypes.put("vst", "application/x-vst");
        contentTypes.put("vsx", "application/vnd.visio");
        contentTypes.put("vxml", "text/xml");
        contentTypes.put("wax", "audio/x-ms-wax");
        contentTypes.put("wb2", "application/x-wb2");
        contentTypes.put("wbmp", "image/vnd.wap.wbmp");
        contentTypes.put("wk3", "application/x-wk3");
        contentTypes.put("wkq", "application/x-wkq");
        contentTypes.put("wm", "video/x-ms-wm");
        contentTypes.put("wmd", "application/x-ms-wmd");
        contentTypes.put("wml", "text/vnd.wap.wml");
        contentTypes.put("wmx", "video/x-ms-wmx");
        contentTypes.put("wp6", "application/x-wp6");
        contentTypes.put("wpg", "application/x-wpg");
        contentTypes.put("wq1", "application/x-wq1");
        contentTypes.put("wri", "application/x-wri");
        contentTypes.put("ws", "application/x-ws");
        contentTypes.put("wsc", "text/scriptlet");
        contentTypes.put("wvx", "video/x-ms-wvx");
        contentTypes.put("xdr", "text/xml");
        contentTypes.put("xfdf", "application/vnd.adobe.xfdf");
        contentTypes.put("xls", "application/vnd.ms-excel");
        contentTypes.put("xlw", "application/x-xlw");
        contentTypes.put("xpl", "audio/scpls");
        contentTypes.put("xql", "text/xml");
        contentTypes.put("xsd", "text/xml");
        contentTypes.put("xslt", "text/xml");
        contentTypes.put("x_b", "application/x-x_b");
        contentTypes.put("sisx", "application/vnd.symbian.install");
        contentTypes.put("ipa", "application/vnd.iphone");
        contentTypes.put("xap", "application/x-silverlight-app");
    }

    public static <E> E request2Entity(HttpServletRequest request, E obj) {
        Enumeration<String> keys = request.getParameterNames();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            Field field = TReflect.field(obj.getClass(), key);
            if (field==null) {
                continue;
            }
            Class<?> type = field.getType();
            try {
                field.setAccessible(true);
                if (type == String.class) {
                    field.set(obj, request.getParameter(key));
                } else if (type == String[].class) {
                    field.set(obj, request.getParameterValues(key));
                } else if (type == int.class || type == Integer.class) {
                    field.set(obj, new Integer(request.getParameter(key)));
                } else if (type == double.class || type == Double.class) {
                    field.set(obj, new Double(request.getParameter(key)));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return obj;
    }
    
    public static String getContentType(String exFileName) {
        String contentType = contentTypes.get(exFileName);
        return contentType==null?DefaultContentType:contentType;
    }
}
