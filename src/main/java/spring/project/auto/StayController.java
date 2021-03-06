package spring.project.auto;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.AccomDAO;
import dao.CustomerDAO;
import dao.StayDAO;
import util.Common;
import util.Paging;
import vo.AccomVO;
import vo.CustomerVO;
import vo.HotelVO;



@Controller
public class StayController {
	
	@Autowired
	StayDAO stay_dao;
	HttpServletRequest request;
	
	@Autowired
	CustomerDAO customerDAO;
	
	@Autowired
	AccomDAO accomDAO;

	@RequestMapping(value= {"/", "main.do"})
	public String main( Model model ) {
		return "/WEB-INF/views/airbnb/index.jsp";
	}
	@RequestMapping("/list.do")
	public String list(Model model) {
		List<HotelVO> list = stay_dao.selectList();
		model.addAttribute("list", list);
		return "/WEB-INF/views/airbnb/list.jsp";
	}
	
	@RequestMapping("/acc1.do")
	public String acc1(Model model) {
		List<HotelVO> list = stay_dao.selectList();
		model.addAttribute("list", list);
		return "/WEB-INF/views/airbnb/acc1_detail.jsp";
	}
	
	@RequestMapping("/acc2.do")
	public String acc2(Model model) {
		List<HotelVO> list = stay_dao.selectList();
		model.addAttribute("list", list);
		return "/WEB-INF/views/airbnb/acc2_detail.jsp";
	}
	@RequestMapping("/acc3.do")
	public String acc3(Model model) {
		List<HotelVO> list = stay_dao.selectList();
		model.addAttribute("list", list);
		return "/WEB-INF/views/airbnb/acc3_detail.jsp";
	}
	
	@RequestMapping("/loginPage.do")
	public String login(Model model) {
		return "/WEB-INF/views/airbnb/loginPage.jsp";
	}
	@RequestMapping("/signUpPage.do")
	public String signUp(Model model) {
		return "/WEB-INF/views/airbnb/signUpPage.jsp";
	}
	@RequestMapping("/myPage.do")
	public String myPage(Model model) {
		List<AccomVO> list = accomDAO.selectList();
		model.addAttribute("list", list);
		
		 List<CustomerVO> cus = customerDAO.selectList(); 
		 model.addAttribute("cus", cus);
		
		return "/WEB-INF/views/airbnb/myPage.jsp";
	}
	@RequestMapping("/main2.do")
	public String main2(Model model) {
		List<HotelVO> list = stay_dao.selectList();
		model.addAttribute("list", list);
		return "/WEB-INF/views/airbnb/index2.jsp";
	}
	@RequestMapping("/faq.do")
	public String faq( Model model ) {
		return "/WEB-INF/views/airbnb/faq.jsp";
	}
	
	@RequestMapping("/change.do")
	public String change( Model model ) {
		List<CustomerVO> cus = customerDAO.selectList(); 
		 model.addAttribute("cus", cus);
		return "/WEB-INF/views/airbnb/modify.jsp";
	}

		//----------------------- ?????? -------------------------
		// ????????????
		@RequestMapping("/insert.do")
		public String insert(CustomerVO vo) {
			int res = customerDAO.insert1(vo);
			
			return "redirect:loginPage.do";
		}
		
		// ????????? ????????????
		@RequestMapping("/check_id.do")
		@ResponseBody
		public String id_check(String id) {
			CustomerVO vo = customerDAO.id_selectOne(id);
			
			String id_res = "[{'id_result':'no'}]";
			if (vo == null) {
				id_res = "[{'id_result':'yes'}]";
			}
			
			return id_res;
		}
		
		// ????????? ????????????
		@RequestMapping("/check_email.do")
		@ResponseBody
		public String email_check(String email) {
			CustomerVO vo = customerDAO.email_selectOne(email);
			
			String email_res = "[{'email_result':'no'}]";
			if (vo == null) {
				email_res = "[{'email_result':'yes'}]";
			}
			
			return email_res;
		}	
		
		// ?????????
		@RequestMapping("/login.do")
		@ResponseBody
		public String login(HttpSession session, CustomerVO vo) {
			// ???????????? ?????? vo2??? ????????? ???????????? ??????.
			CustomerVO vo2 = customerDAO.login(vo);
			if (vo2 != null) {
				session.setAttribute("loginUser", vo2);
			}
			
			String login_res = "[{'login_result':'yes'}]";
			if (vo2 == null) {
				login_res = "[{'login_result':'no'}]";
			}
				
			return login_res; 
		}	
		
		//????????????
		@RequestMapping("/logout.do")
		public void logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
			try {
				response.setContentType("text/html; charset=utf-8");
				String contextPath = request.getContextPath();
				PrintWriter out = response.getWriter();
				session.invalidate();
				out.print("<script>");
				out.print("alert('???????????? ???????????????.');");
				out.print(String.format("location.href='%s/main.do';", contextPath));
				out.print("</script>");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		// ????????????
		@RequestMapping("/reserv.do")
		public String insert(AccomVO vo) {
		int res = accomDAO.insert(vo);
					
		return "redirect:myPage.do";
		}
		
		
		// ???????????? ??????
		@RequestMapping("/myReservation.do")
		public String myReservation(Model model) {
			List<AccomVO> list = accomDAO.selectList();
			
			model.addAttribute("list", list);
			
			return "/WEB-INF/views/airbnb/myPage.jsp";
		}
		
		// ?????? ??????
		@RequestMapping("/delete.do")
		public String delete(Model model) {
			int res = accomDAO.delete();
			
			return "redirect:myPage.do";		 
		}
		
		
		  //?????????
		  @RequestMapping("/modify.do")
		 @ResponseBody 
		  public String modify( CustomerVO vo ) {
		  
		  int res = customerDAO.update(vo);
		  
		 String result = "no"; 
		  if(res == 1) { 
			  result = "yes"; 
		  }
		  return result;
		  }
		 
		

		//----------------------- /?????? -------------------------
	
		
		  @RequestMapping("/list2.do") 
		  public String list2(Model model) { 
			  List<HotelVO> list = stay_dao.selectList(); model.addAttribute("list", list); 
		  return "/WEB-INF/views/airbnb/testlist.jsp"; 
		  }
		 

		//----------------------- /????????? -------------------------

		/*	@RequestMapping(value= {"/page.do"})
			public String list(Model model, String page) {
		
				int nowPage = 1;//?????? ???????????? 1

				if( page != null && !page.isEmpty() ) {
					nowPage = Integer.parseInt(page);
				}

				int start = (nowPage - 1) * Common.Board.BLOCKLIST + 1;
				int end = start + Common.Board.BLOCKLIST - 1;

				HashMap<String, Integer> map = new HashMap<String, Integer>();
				map.put("start", start);
				map.put("end", end);

				//??????????????? ?????? ????????????
				List<HotelVO> list = stay_dao.selectList(map);

				//??????????????? ?????? ?????????
				int rowTotal = stay_dao.getRowTotal();

				//????????? ?????? ?????????
				String pageMenu = Paging.getPaging(
						"page.do", //?????? ???????????? url??????
						nowPage, //?????? ????????? ??????
						rowTotal, //?????? ????????? ???
						Common.Board.BLOCKLIST, //??? ???????????? ????????? ????????? ???
						Common.Board.BLOCKPAGE); //?????? ????????? ?????? ???

				model.addAttribute("list", list);//?????????
				model.addAttribute("pageMenu", pageMenu);

				//????????? ???????????? ?????? "show"?????? ???????????? ??????
				request.getSession().removeAttribute("show");

				return "/WEB-INF/views/airbnb/testlist.jsp";
			}//list() */

	}

