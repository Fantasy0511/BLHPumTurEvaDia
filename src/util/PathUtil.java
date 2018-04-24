package util;

import java.io.File;

import org.apache.struts2.ServletActionContext;

/**
 * 获取相关路径。可以运行测试查看效果。注意区分eclipse项目路径、类路径、web项目路径。主要功能：
 * <ul>
 * <li>获得web服务器开启时的项目目录绝对路径</li>
 * <li>获得web服务器开启时的项目相对路径</li>
 * <li>获得项目路径，即源代码路径</li>
 * </ul>
 * 
 * @author hx
 */
public class PathUtil {
	private static final String RESOURCE_FOLDER = "/WEB-INF/content";
	private static final String PROJECT_NAME = "BLHPumTurEvaDia";

	/**
	 * web项目被发布到服务器中以后获得路径的方式。当不在web环境下的时候返回项目源代码路径下的WebContent文件夹路径。
	 * 
	 * @return 当前项目的根目录的绝对路径。
	 */
	public static String getWebRealBasePath() {
		boolean webOn = true;
		if (webOn) {
			return getClassPath(PathUtil.class).replace("WEB-INF/classes/", "");
		} else {
			return getProjectPath() + "\\WebContent";
		}
	}

	/**
	 * 返回请求指向的上下文路径，通常是项目名。例如本项目为：/HPPumTurReg。不在web环境下时返回null。
	 * 
	 * @return 项目根目录。
	 */
	public static String getWebRelativeBasePath() {
		String base = null;
		try {
			base = ServletActionContext.getRequest().getContextPath();
		} catch (NullPointerException e) {
			base = null;
		}
		return base;
	}

	/**
	 * 传入类对象，获取类路径。类路径为源文件编译后的路径，一般是名为class文件夹。
	 * 
	 * @param clazz
	 *            类
	 * @return 类路径
	 */
	public static <T> String getClassPath(Class<T> clazz) {
		return clazz.getClassLoader().getResource("").getPath();
	}

	/**
	 * 项目的绝对路径。
	 * 
	 * @return 项目源路径。
	 */
	public static String getProjectPath() {
		return new File("").getAbsolutePath();
	}

	public static String getPageRequestRealPath() {
		return getWebRealBasePath()
				+ RESOURCE_FOLDER
				+ ServletActionContext.getRequest().getRequestURI()
						.replaceFirst("/" + PROJECT_NAME, "");
	}

	public static String getPageRequestRelativePath(String suffix) {
		return RESOURCE_FOLDER
				+ ServletActionContext.getRequest().getRequestURI()
						.replaceFirst("/" + PROJECT_NAME, "") + suffix;
	}

	public static void main(String[] args) {
		TestUtil.print("web real base path: " + getWebRealBasePath());
		TestUtil.print("class path: " + getClassPath(PathUtil.class));
		TestUtil.print("project source path: " + getProjectPath());
		TestUtil.print("true if no web: " + (getWebRelativeBasePath() == null));
	}

}
