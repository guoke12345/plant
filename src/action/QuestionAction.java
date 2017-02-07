package action;


import java.util.List;

import pojo.Question;
import service.IQuestionService;

import com.framework.core.utils.DateUtils;
import com.opensymphony.xwork2.ActionSupport;

public class QuestionAction extends ActionSupport {
	private IQuestionService questionService;
	private List<Question> quesList;
	private Question question;
	private String title;
	private String content;
	private String img;
	private String answer;
	private String xpoint;
	private String ypoint;
	private String result;
	private String location;
	private int id;
	public String toList(){
		quesList = questionService.allList();
		return "list";
	}
	public String toAdd(){
		return "add";
	}
	public String toEdit(){
		question = questionService.art(id);
		return "edit";
	}
	public String toDelete(){
		questionService.delete(id);
		return "toList";
	}
	public String add(){
		question = new Question();
		question.setXpoint(xpoint);
		question.setYpoint(ypoint);
		question.setAnswer(answer);
		question.setContent(content);
		question.setTitle(title);
		question.setLocation(location);
		question.setImg(img);
		question.setTime(DateUtils.formatDate("yyyy-MM-dd HH:mm:ss"));
		try{
			questionService.add(question);
			result = "success";
		}catch(Exception ex){
			result ="fail";
			ex.printStackTrace();
		}
		return "ajaxSuccess";
	}
	public String edit(){
		question = new Question();
		question.setId(id);
		question.setXpoint(xpoint);
		question.setYpoint(ypoint);
		question.setAnswer(answer);
		question.setContent(content);
		question.setTitle(title);
		question.setLocation(location);
		question.setImg(img);
		question.setTime(DateUtils.formatDate("yyyy-MM-dd HH:mm:ss"));
		try{
			questionService.modify(question);
			result = "success";
		}catch(Exception ex){
			result ="fail";
			ex.printStackTrace();
		}
		return "ajaxSuccess";
	}
	public List<Question> getQuesList() {
		return quesList;
	}

	public void setQuesList(List<Question> quesList) {
		this.quesList = quesList;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public void setQuestionService(IQuestionService questionService) {
		this.questionService = questionService;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getXpoint() {
		return xpoint;
	}
	public void setXpoint(String xpoint) {
		this.xpoint = xpoint;
	}
	public String getYpoint() {
		return ypoint;
	}
	public void setYpoint(String ypoint) {
		this.ypoint = ypoint;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}
