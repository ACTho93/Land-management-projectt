package vn.edu.vinaenter.controller;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vn.edu.vinaenter.constant.Defines;
import vn.edu.vinaenter.model.bean.Category;
import vn.edu.vinaenter.model.bean.Comment;
import vn.edu.vinaenter.model.bean.Contact;
import vn.edu.vinaenter.model.bean.Land;
import vn.edu.vinaenter.model.bean.User;
import vn.edu.vinaenter.model.dao.CategoryDAO;
import vn.edu.vinaenter.model.dao.CommentDAO;
import vn.edu.vinaenter.model.dao.ContactDAO;
import vn.edu.vinaenter.model.dao.LandDAO;

@Controller
//@SessionAttributes("landd")
public class PublicController {

	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private LandDAO landDAO;
	
	@Autowired
	private ContactDAO contactDAO;
	
	@Autowired
	private CommentDAO commentDAO;
	
	private List<Comment> listCmtById = new ArrayList<>();
	

	@ModelAttribute
	public void commonObject(ModelMap modelMap) {
		
		List<Category> categoriess = categoryDAO.getItems();
		
		
		
		
		modelMap.addAttribute("categoriess", categoriess);
		
		List<Category> categories = categoryDAO.getCategoriesWithTotal();
		modelMap.addAttribute("categories", categories);
		
		List<Land> landOfcount = landDAO.getItemsByCountView();
		modelMap.addAttribute("landOfcount", landOfcount);
	}
	
//	public void CreateChildMenu(int parentId, javax.servlet.jsp.JspWriter out) throws IOException{
//	 
//	            List<String> idChildMenu=new ArrayList<>();
//	            List<String> nameChildMenu=new ArrayList<>();
//	 
//	            List<Category> categoriess = categoryDAO.getItems();
//	            
//				for (Category category : categoriess) {
//					if (category.getParent_id() == parentId) {
//						out.println("<li>");
//
//						idChildMenu.add("parentId");
//						nameChildMenu.add(category.getName());
//					}
//
//				}
//
//				if (idChildMenu.size() > 0)// Nếu tồn tại menu con với parent_id=parentId
//				{
//					out.println("<ul>"); // Bắt đầu một phân cấp với thẻ <ul>
//					for (int i = 0; i < idChildMenu.size(); i++) {
//						out.println("<li>"); // Bắt đầu một dòng menu con với thẻ <li>
//						out.println(
//								"<a\r\n" + "	href=\"${pageContext.request.contextPath}/danh-muc/${SlugUtil.makeSlug("
//										+ nameChildMenu.get(i) + ")}-" + idChildMenu.get(i) + "\">"
//										+ nameChildMenu.get(i) + "</a>");
//						CreateChildMenu(Integer.parseInt(idChildMenu.get(i)), out);
//					}
//					out.println("</ul>"); // Kết thúc một phân cấp với thẻ </ul>
//				} else {
//					out.println("</li>");
//				}
//			}
//	          
//	public void CreateMenu(javax.servlet.jsp.JspWriter out, ModelMap modelMap) throws IOException{
//		
//		 out.println("<nav>");
//		 out.println("<ul>");
//		 List<Category> categoriess = categoryDAO.getItems();
//		 
//		 for (Category category : categoriess) {
//			if (category.getParent_id() == 0) {
//				 out.println("<li>");
//
//                 //In tất cả menu cha cấp 0 (parent_id=0)
//				 out.println("<a\r\n"
//				 		+ "	href=\"${pageContext.request.contextPath}/danh-muc/${SlugUtil.makeSlug("+category.getName()+")}-"+category.getId()+"\">"+category.getName()+"</a>");
//                 CreateChildMenu(category.getId(),out);
//			}
//			 
//		}
//		 out.println("</ul>");
//		 out.println("</nav>");
//	}
//	
	
	@GetMapping("")
	public String index(@RequestParam(name ="page", required = false) Integer page, ModelMap modelMap) { // required cho truong hop trang thu 1
		
		
		int numberOfItems = landDAO.countItems();
		int numberOfPages = (int) Math.ceil(numberOfItems * 1.0 / Defines.ROW_COUNT); // * 1.0 de ep kieu ve so thuc
		
		
		if (page == null) {
			page = 1;
		}else if (page < 1){
			return "redirect:/?page=1";
		}else if (page > numberOfPages){
			return "redirect:/?page="+numberOfPages;
		}
		
		
		int offset = (page - 1 ) * Defines.ROW_COUNT;
		
		List<Land> lands = landDAO.getItemsPagination(offset);
		modelMap.addAttribute("lands", lands);
		modelMap.addAttribute("page", page);
		modelMap.addAttribute("numberOfPages", numberOfPages);
		
		
		return "cland.public.index";
	}
	
	

	
	@GetMapping("cat")
	public String cat() {
		
		return "cland.public.cat";
	}
	
	@GetMapping("danh-muc/{catName}-{id}")
	public String cat(@PathVariable int id, ModelMap modelMap) {
		
		List<Land> lands = landDAO.getItemsByCategoryId(id);
		modelMap.addAttribute("lands", lands);
		
		Category cate = categoryDAO.getItem(id);
		modelMap.addAttribute("cate", cate);
		
		modelMap.addAttribute("id", id);
		
		
		
		return "cland.public.cat";
	}
	
	@GetMapping("lien-he")
	public String contact() {
		
		return "cland.public.contact";
	}
	
	@PostMapping("lien-he")
	public String contact(@Valid @ModelAttribute("contact") Contact contact,BindingResult br, RedirectAttributes ra, ModelMap modelMap) {
		
		if (br.hasErrors()) {
			ra.addFlashAttribute("msg", Defines.MSG_ERROR);
			return "cland.public.contact";
		}
		
		
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MailSender mailSender = (MailSender) context.getBean("mailSender2");
		System.out.println("Sending text...");
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(contact.getEmail());
		message.setTo(contact.getEmailto());
		message.setSubject("Subject");
		message.setText("test send gmail using spring");
		// sending message
		mailSender.send(message);
		System.out.println("Sending text done!");
		context.close();
			
		
//		String username = "thodhnt@gmail.com";
//	   	  Properties properties = new Properties();
//	   	  properties.setProperty("mail.smtp.auth","true");
//	   	  properties.setProperty("mail.smtp.starttls.enable", "true");
//	   	  properties.setProperty("mail.smtp.host", "smtp.gmail.com");
//	   	  properties.setProperty("mail.smtp.port", "587");
//	   	  Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
//	   		  protected PasswordAuthentication getPasswordAuthentication() {
//	   			  String username ="thodhnt@gmail.com";
//	   			  String password="zaesriodpkxtglwe";
//	   			  return new PasswordAuthentication(username, password);	    			  
//	   		  }  
//	   	  });
//	   	 try {
//	   		 MimeMessage mess = new MimeMessage(session);
//		    	  mess.setFrom(new InternetAddress(username));
//				  mess.setRecipient(Message.RecipientType.TO, new InternetAddress(contact.getEmailto()));
//				  mess.setSubject("Nội dung thư");
//				  mess.setText("Ten: "+contact.getFullname()+ "\nmess:" + contact.getContent());
//				  //send mess
//				  Transport.send(mess);
//				  //System.out.println("send succesfull!!!");
//					
//				 
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//		
		
		
		
		if (contactDAO.add(contact) > 0) {
			ra.addFlashAttribute("msg", Defines.MSG_SEND_SUCCESS);
			return "redirect:/lien-he";
		} else {
			ra.addFlashAttribute("msg", Defines.MSG_ERROR);
			return "redirect:/lien-he";
		}
		
	}
	
	@GetMapping("single1")
	public String single(ModelMap modelMap) {
		
		List<Land> landd = landDAO.getItemsIntro();
		modelMap.addAttribute("landd", landd);
		
		return "cland.public.single1";
	}
	
	
	 @ModelAttribute("landd")
	    public Land setUpCounter() {
	        return new Land();
	    }
	
	@GetMapping("{landName}-{id}.html")
	public String single(@PathVariable int id,@ModelAttribute Comment comment,HttpServletRequest request ,ModelMap modelMap) {
		
		HttpSession session = request.getSession();
		User userLogin = (User) session.getAttribute("userLogin");
		
		listCmtById = commentDAO.getItems(id);
		modelMap.addAttribute("listCmtById", listCmtById);
		
		
		boolean checkLike = landDAO.checkLike(userLogin.getId(), id);
		modelMap.addAttribute("checkLike", checkLike);
		
		int countLike = landDAO.countLike(id);
		modelMap.addAttribute("countLike", countLike);

		
		
		Land landById = landDAO.getItemById(id);
		
		String hasVisited = (String)session.getAttribute("hasVisited:"+id); // mục đích tạo ra 1 Attribute tron

		if (hasVisited == null) { // người đó chưa xem bài viết bao giờ
			session.setAttribute("hasVisited:"+id, "yes");
			session.setMaxInactiveInterval(3600);
			// sau một thời gian quy định, sẽ tự động mất session và tăng lượt view
			landDAO.increaseView(id);

		}

		
		List<Land> listlandRelated = landDAO.getItemsRelated(landById);
		modelMap.addAttribute("landById", landById);
		modelMap.addAttribute("land", landById);
		modelMap.addAttribute("listlandRelated", listlandRelated);
		
		return "cland.public.single";
		
	}
	
	
	
	@PostMapping("single/{id}")
	@ResponseBody
	public void singlle(@PathVariable int id,@RequestParam String cmt, HttpServletResponse response) throws IOException {
		
		Comment objCmt = new Comment(0, cmt, id);
		
		if (commentDAO.addCMT(objCmt) > 0) {
			listCmtById.add(objCmt);
			//System.out.println("Thêm comment thành công");
		} else {
			//System.out.println("Thêm comment thất bại");
		}
		
		if (listCmtById != null) {
			for (Comment item : listCmtById) {
				response.getWriter().print("<div class=\"article\">\r\n"
						+ "						<input type=\"text\" name=\"\" id=\"\" value=\""+item.getComment()+"\"\r\n"
						+ "					/> \r\n"
						+ "					<p>\r\n"
						+ "					<span><a style=\"font-size: 10px; padding-left: 45px\" href=\"javascript:void(0)\">Thích</a></span>      \r\n"
						+ "						<span><a style=\"font-size: 10px; padding-left: 55px\" href=\"javascript:void(0)\" >Phản hồi</a></span>\r\n"
						+ "				</p>\r\n"
					
						+ "			\r\n"
						+ "				\r\n"
						+ "			</div>");
			}
		}
		
		
	}
	
	@GetMapping("search")
	public String search(@RequestParam(name ="page", required = false) Integer page, @RequestParam String search, ModelMap modelMap) {
		
		int numberOfItems = landDAO.countItemsByName(search);
		
		int numberOfPages = (int) Math.ceil(numberOfItems * 1.0 / Defines.ROW_COUNT); // * 1.0 de ep kieu ve so thuc
		
		
		if (page == null) {
			page = 1;
		}else if (page < 1){
			return "redirect:/search/?page=1";
		}else if (page > numberOfPages){
			return "redirect:/search/?page="+numberOfPages;
		}
		
		
		int offset = (page - 1 ) * Defines.ROW_COUNT;
		
		
		List<Land> listlandsSearch = landDAO.getItemsSearch(search, offset);
		
		modelMap.addAttribute("listlandsSearch", listlandsSearch);
		modelMap.addAttribute("page", page);
		modelMap.addAttribute("numberOfPages", numberOfPages);
		
		return "cland.public.search";
	}
	
}
