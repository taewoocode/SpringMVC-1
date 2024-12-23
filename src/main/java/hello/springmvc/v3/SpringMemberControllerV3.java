package hello.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    /** method Level **/
//    @RequestMapping(value = "/new-form", method = RequestMethod.GET)
    @GetMapping
    public String newForm() {
        return "new-form";
    }

    @RequestMapping("/members")
    public ModelAndView members() {
        List<Member> members = memberRepository.findAll();
        ModelAndView mv = new ModelAndView("members");
        mv.addObject("members", members);
        return mv;
    }

//    @RequestMapping("/save")
//    public ModelAndView save(HttpServletRequest request, HttpServletResponse response) {
//        String username = request.getParameter("username");
//        int age = Integer.parseInt(request.getParameter("age"));
//
//        Member member = new Member(username, age);
//        memberRepository.save(member);
//
//        ModelAndView mv = new ModelAndView("save-result");
//        mv.addObject("member", member);
//        return mv;
//    }

//    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @PostMapping
    public String save(
            @RequestParam("username") String username,
            @RequestParam("age") int age,
            Model model) {

        Member member = new Member(username, age);
        memberRepository.save(member);

        model.addAttribute("member", member);
        return "save-result";
    }

//    @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public String members(Model model) {
        List<Member> members = memberRepository.findAll();
        model.addAttribute("members", members);
        return "members";
    }
}
