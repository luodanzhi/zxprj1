package com.zx.common;


/**
 * We have two other ways to get the MIME type,
 * One is android.webkit.MimeTypeMap, and the other is java.net.URLConnection. 
 * but NONE of them defines all MIMEs
 * to avoid the fault, we get the MIME type by ourselves.
 */


public class MimeTypeTable {
	private static final String[][] mMimeTypePair = {
		{	"dwg"	,	"application/acad"	},
		{	"asn"	,	"application/astound"	},
		{	"asd"	,	"application/astound"	},
		{	"tsp"	,	"application/dsptype"	},
		{	"dxf"	,	"application/dxf"	},
		{	"spl"	,	"application/futuresplash"	},
		{	"gz"	,	"application/gzip"	},
		{	"ptlk"	,	"application/listenup"	},
		{	"hqx"	,	"application/mac-binhex40"	},
		{	"mbd"	,	"application/mbedlet"	},
		{	"mif"	,	"application/mif"	},
		{	"xls"	,	"application/msexcel"	},
		{	"xla"	,	"application/msexcel"	},
		{	"hlp"	,	"application/mshelp"	},
		{	"chm"	,	"application/mshelp"	},
		{	"ppt"	,	"application/mspowerpoint"	},
		{	"ppz"	,	"application/mspowerpoint"	},
		{	"pps"	,	"application/mspowerpoint"	},
		{	"pot"	,	"application/mspowerpoint"	},
		{	"doc"	,	"application/msword"	},
		{	"dot"	,	"application/msword"	},
		{	"bin"	,	"application/octet-stream"	},
		{	"exe"	,	"application/octet-stream"	},
		{	"com"	,	"application/octet-stream"	},
		{	"dll"	,	"application/octet-stream"	},
		{	"class"	,	"application/octet-stream"	},
		{	"oda"	,	"application/oda"	},
		{	"pdf"	,	"application/pdf"	},
		{	"ai"	,	"application/postscript"	},
		{	"eps"	,	"application/postscript"	},
		{	"ps"	,	"application/postscript"	},
		{	"rtc"	,	"application/rtc"	},
		{	"rtf"	,	"application/rtf"	},
		{	"smp"	,	"application/studiom"	},
		{	"tbk"	,	"application/toolbook"	},
		{	"vmd"	,	"application/vocaltec-media-desc"	},
		{	"vmf"	,	"application/vocaltec-media-file"	},
		{	"bcpio"	,	"application/x-bcpio"	},
		{	"z"	,	"application/x-compress"	},
		{	"cpio"	,	"application/x-cpio"	},
		{	"csh"	,	"application/x-csh"	},
		{	"dcr"	,	"application/x-director"	},
		{	"dir"	,	"application/x-director"	},
		{	"dxr"	,	"application/x-director"	},
		{	"dvi"	,	"application/x-dvi"	},
		{	"evy"	,	"application/x-envoy"	},
		{	"gtar"	,	"application/x-gtar"	},
		{	"hdf"	,	"application/x-hdf"	},
		{	"php"	,	"application/x-httpd-php"	},
		{	"phtml"	,	"application/x-httpd-php"	},
		{	"js"	,	"application/x-javascript"	},
		{	"latex"	,	"application/x-latex"	},
		{	"bin"	,	"application/x-macbinary"	},
		{	"mif"	,	"application/x-mif"	},
		{	"nc"	,	"application/x-netcdf"	},
		{	"cdf"	,	"application/x-netcdf"	},
		{	"nsc"	,	"application/x-nschat"	},
		{	"sh"	,	"application/x-sh"	},
		{	"shar"	,	"application/x-shar"	},
		{	"swf"	,	"application/x-shockwave-flash"	},
		{	"cab"	,	"application/x-shockwave-flash"	},
		{	"spr"	,	"application/x-sprite"	},
		{	"sprite"	,	"application/x-sprite"	},
		{	"sit"	,	"application/x-stuffit"	},
		{	"sca"	,	"application/x-supercard"	},
		{	"sv4cpio"	,	"application/x-sv4cpio"	},
		{	"sv4crc"	,	"application/x-sv4crc"	},
		{	"tar"	,	"application/x-tar"	},
		{	"tcl"	,	"application/x-tcl"	},
		{	"tex"	,	"application/x-tex"	},
		{	"texinfo"	,	"application/x-texinfo"	},
		{	"texi"	,	"application/x-texinfo"	},
		{	"t"	,	"application/x-troff"	},
		{	"tr"	,	"application/x-troff"	},
		{	"roff"	,	"application/x-troff"	},
		{	"troff"	,	"application/x-troff-man"	},
		{	"man"	,	"application/x-troff-man"	},
		{	"me"	,	"application/x-troff-me"	},
		{	"ustar"	,	"application/x-ustar"	},
		{	"src"	,	"application/x-wais-source"	},
		{	"zip"	,	"application/zip"	},
		{	"au"	,	"audio/basic"	},
		{	"snd"	,	"audio/basic"	},
		{	"es"	,	"audio/echospeech"	},
		{	"tsi"	,	"audio/tsplayer"	},
		{	"vox"	,	"audio/voxware"	},
		{	"aif"	,	"audio/x-aiff"	},
		{	"aiff"	,	"audio/x-aiff"	},
		{	"aifc"	,	"audio/x-aiff"	},
		{	"dus"	,	"audio/x-dspeeh"	},
		{	"cht"	,	"audio/x-dspeeh"	},
		{	"mid"	,	"audio/x-midi"	},
		{	"midi"	,	"audio/x-midi"	},
		{	"mp2"	,	"audio/x-mpeg"	},
		{	"ram"	,	"audio/x-pn-realaudio"	},
		{	"ra"	,	"audio/x-pn-realaudio"	},
		{	"rpm"	,	"audio/x-pn-realaudio-plugin"	},
		{	"stream"	,	"audio/x-qt-stream"	},
		{	"wav"	,	"audio/x-wav"	},
		{	"mp3"	,	"audio/mpeg"	},
		{	"imy"	,	"audio/melody"	},
		{	"qcp"	,	"audio/qcelp"	},
		{	"amr"	,	"audio/amr"	},
		{	"dwf"	,	"drawing/x-dwf"	},
		{	"cod"	,	"image/cis-cod"	},
		{	"ras"	,	"image/cmu-raster"	},
		{	"fif"	,	"image/fif"	},
		{	"gif"	,	"image/gif"	},
		{	"ief"	,	"image/ief"	},
		{	"jpeg"	,	"image/jpeg"	},
		{	"jpg"	,	"image/jpeg"	},
		{	"jpe"	,	"image/jpeg"	},
		{	"tiff"	,	"image/tiff"	},
		{	"tif"	,	"image/tiff"	},
		{	"png"	,	"image/png"	},
		{	"mcf"	,	"image/vasa"	},
		{	"wbmp"	,	"image/vnd.wap.wbmp"	},
		{	"fh4"	,	"image/x-freehand"	},
		{	"fh5"	,	"image/x-freehand"	},
		{	"fhc"	,	"image/x-freehand"	},
		{	"pnm"	,	"image/x-portable-anymap"	},
		{	"pbm"	,	"image/x-portable-bitmap"	},
		{	"pgm"	,	"image/x-portable-graymap"	},
		{	"ppm"	,	"image/x-portable-pixmap"	},
		{	"rgb"	,	"image/x-rgb"	},
		{	"xwd"	,	"image/x-windowdump"	},
		{	"xbm"	,	"image/x-xbitmap"	},
		{	"xpm"	,	"image/x-xpixmap"	},
		{	"wrl"	,	"model/vrml"	},
		{	"csv"	,	"text/comma-separated-values"	},
		{	"css"	,	"text/css"	},
		{	"htm"	,	"text/html"	},
		{	"html"	,	"text/html"	},
		{	"shtml"	,	"text/html"	},
		{	"js"	,	"text/javascript"	},
		{	"txt"	,	"text/plain"	},
		{	"rtx"	,	"text/richtext"	},
		{	"rtf"	,	"text/rtf"	},
		{	"tsv"	,	"text/tab-separated-values"	},
		{	"wml"	,	"text/vnd.wap.wml"	},
		{	"wmls"	,	"text/vnd.wap.wmlscript"	},
		{	"etx"	,	"text/x-setext"	},
		{	"sgm"	,	"text/x-sgml"	},
		{	"sgml"	,	"text/x-sgml"	},
		{	"talk"	,	"text/x-speech"	},
		{	"spc"	,	"text/x-speech"	},
		{	"vcf"	,	"text/x-vcard"	},
		{	"vcs"	,	"text/x-vcalendar"	},
		{	"wmlc"	,	"application/vnd.wap.wmlc"	},
		{	"wmlsc"	,	"application/vnd.wap.wmlscriptc"	},
		{	"3gp"	,	"video/3gpp"	},
		{	"3g2"	,	"video/3gpp2"	},
		{	"mpeg"	,	"video/mpeg"	},
		{	"mpg"	,	"video/mpeg"	},
		{	"mpe"	,	"video/mpeg"	},
		{	"qt"	,	"video/quicktime"	},
		{	"mov"	,	"video/quicktime"	},
		{	"viv"	,	"video/vnd.vivo"	},
		{	"vivo"	,	"video/vnd.vivo"	},
		{	"avi"	,	"video/x-msvideo"	},
		{	"movie"	,	"video/x-sgi-movie"	},
		{	"vts"	,	"workbook/formulaone"	},
		{	"vtts"	,	"workbook/formulaone"	},
		{	"3dmf"	,	"x-world/x-3dmf"	},
		{	"3dm"	,	"x-world/x-3dmf"	},
		{	"qd3d"	,	"x-world/x-3dmf"	},
		{	"qd3"	,	"x-world/x-3dmf"	},
		{	"wrl"	,	"x-world/x-vrml"	},
		{	"smil"	,	"application/smil"	},
		{	"dcf"	,	"application/vnd.oma.drm.content"	},
		{	"jar"	,	"application/java-archive"	},
		{	"jad"	,	"text/vnd.sun.j2me.app-descriptor"	},
		// added by luodan
		{	"mp4"	,	 "video/mp4"},
		{	"docx"	,	 "application/vnd.openxmlformats-officedocument.wordprocessingml.document"},
	};

    public static final String IMAGE_UNSPECIFIED = "image/*";
    public static final String IMAGE_JPEG        = "image/jpeg";
    public static final String IMAGE_JPG         = "image/jpg";
    public static final String IMAGE_GIF         = "image/gif";
    public static final String IMAGE_WBMP        = "image/vnd.wap.wbmp";
    public static final String IMAGE_PNG         = "image/png";

    public static final String AUDIO_UNSPECIFIED = "audio/*";
    public static final String AUDIO_AAC         = "audio/aac";
    public static final String AUDIO_AMR         = "audio/amr";
    public static final String AUDIO_IMELODY     = "audio/imelody";
    public static final String AUDIO_MID         = "audio/mid";
    public static final String AUDIO_MIDI        = "audio/midi";
    public static final String AUDIO_MP3         = "audio/mp3";
    public static final String AUDIO_MPEG3       = "audio/mpeg3";
    public static final String AUDIO_MPEG        = "audio/mpeg";
    public static final String AUDIO_MPG         = "audio/mpg";
    public static final String AUDIO_MP4         = "audio/mp4";
    public static final String AUDIO_X_MID       = "audio/x-mid";
    public static final String AUDIO_X_MIDI      = "audio/x-midi";
    public static final String AUDIO_X_MP3       = "audio/x-mp3";
    public static final String AUDIO_X_MPEG3     = "audio/x-mpeg3";
    public static final String AUDIO_X_MPEG      = "audio/x-mpeg";
    public static final String AUDIO_X_MPG       = "audio/x-mpg";
    public static final String AUDIO_3GPP        = "audio/3gpp";
    public static final String AUDIO_OGG         = "application/ogg";

    public static final String VIDEO_UNSPECIFIED = "video/*";
    public static final String VIDEO_3GPP        = "video/3gpp";
    public static final String VIDEO_3G2         = "video/3gpp2";
    public static final String VIDEO_H263        = "video/h263";
    public static final String VIDEO_MP4         = "video/mp4";

	
	
	public MimeTypeTable() {
	}
	
	
	/**
	 * Get MIME type from file name
	 * We have other two ways to get the MIME type,
	 * One is android.webkit.MimeTypeMap, and the other is java.net.URLConnection. 
	 * but NONE of them defines all MIMEs
	 * 
	 * return null if MIME doesn't find or errors occur
	 */
	
	public static final String getContentType(String fileName) {
		String suffix = null;
		
		if (fileName == null || fileName.equals("")) {
			return null;
		}
		
		suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
		if (suffix == null) {
			return null;
		}
		
		for (int i = 0; i < mMimeTypePair.length; i++) {
			if (mMimeTypePair[i][0].equalsIgnoreCase(suffix)) {
				return mMimeTypePair[i][1];
			}
		}
		
		return null;
	}
}
