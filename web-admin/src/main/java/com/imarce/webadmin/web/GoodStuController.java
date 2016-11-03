package com.imarce.webadmin.web;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.imarce.core.utils.DateUtils;
import com.imarce.core.utils.PicUtil;
import com.imarce.webadmin.entity.Student;
import com.imarce.webadmin.entity.vo.Coodinate;
import com.imarce.webadmin.service.GoodStuService;
import com.imarce.webadmin.util.DataGridData;
import com.imarce.webadmin.util.FileUtil;
import com.imarce.webadmin.util.Pager;
import com.imarce.webadmin.util.Result;

/**
 * Author: Qian
 * 
 * Date: 2016年7月6日
 * 
 * Description:
 */
@Controller
public class GoodStuController {
	/**
	 * 
	 */
	@Autowired
	GoodStuService goodStuService;

	/**
	 * @return 返回DataGridData类型，类似json数据的格式
	 */
	@RequestMapping("/good_stu")
	@ResponseBody
	public DataGridData queryGoodStu(Pager page) {
		DataGridData dataGridData = goodStuService.queryGoodStu(page);
		return dataGridData;
	}

	@RequestMapping("/save_student_basic")
	@ResponseBody
	public Result saveStudentBasic(Student student,String knowledgeStr) {
		Result result = new Result();
		if (!goodStuService.saveStudentBasic(student,knowledgeStr)) {
			result.setInfo("10002", "用户保存失败!");
		}
		return result;
	}

	@RequestMapping("/query_registed_stu_by_id")
	public String queryRegistedStuById(Model model, int studentId) {
		Student student = goodStuService.queryRegistedStuById(studentId);
		model.addAttribute("student", student);
		return "stu_message";
	}

	@RequestMapping("/update_stu")
	@ResponseBody
	public Result updateStu(Student student,String knowledgeStr) {
		Result result = new Result();
		if (!goodStuService.updateStu(student,knowledgeStr)) {
			result.setInfo("10002", "用户修改失败!");
		}
		return result;
	}

	@RequestMapping("/delete_stu")
	@ResponseBody
	public Result deleteStu(int studentId) {	
		Result result = new Result();		
		if (!goodStuService.deleteStu(studentId)) {
			result.setInfo("10002", "用户删除失败!");
		}
		return result;
	}

	@RequestMapping("/avatar_upload")
	@ResponseBody
	public String avatarUpload(MultipartFile Filedata, HttpServletRequest request) {
		InputStream is = null;
		FileOutputStream fos = null;
		String storePath = "";
		try {
			is = Filedata.getInputStream();
			String appPath = request.getSession().getServletContext().getRealPath("/");
			storePath = FileUtil.mkFileName(appPath, Filedata.getOriginalFilename());

			fos = new FileOutputStream(appPath + "/" + storePath);

			byte datas[] = new byte[1024];
			int readed = 0;
			while ((readed = is.read(datas)) > 0) {
				fos.write(datas, 0, readed);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return storePath;
	}

	@RequestMapping("/save_student_headicon")
	@ResponseBody
	public String saveStudentHeadicon(Coodinate coodinate, HttpServletRequest request) {
		String appPath = request.getSession().getServletContext().getRealPath("/");
		String dir = "uploadFiles/userIcon/" + DateUtils.formatDate(new Date(), "yyyyMM");
		FileUtil.ensureDirectory(appPath, dir);
		// String targetDir = FileUtil.ensureDirectory(appPath,+"/userIcon");
		String snailPath = dir + "/" + FileUtil.createPicName(coodinate.getFilePath());
		PicUtil.uploadPic(appPath + "/" + coodinate.getFilePath(), appPath + "/" + snailPath, coodinate.getX(),
				coodinate.getY(), coodinate.getX2(), coodinate.getY2(), coodinate.getW(), coodinate.getH());
		return snailPath;
	}

}
