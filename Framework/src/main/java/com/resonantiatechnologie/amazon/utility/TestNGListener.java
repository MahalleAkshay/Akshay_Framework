package com.resonantiatechnologie.amazon.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class TestNGListener implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailure(ITestResult result) {
		AShot as = new AShot();
		Date d = new Date();
		SimpleDateFormat Formatter = new SimpleDateFormat("-E, dd MMM yyyy, HH_mm_ss");

		String DateFormat = Formatter.format(d);

		Screenshot sc = as.shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(Constants.driver);

		try {
			ImageIO.write(sc.getImage(), "PNG",
					new File("C:\\EclipseWorkspace\\Framework\\ScreenShot\\" + DateFormat + ".png"));
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}