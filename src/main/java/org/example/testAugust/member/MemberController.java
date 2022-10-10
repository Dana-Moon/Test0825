package org.example.testAugust.member;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
@RequestMapping(path = "/member")
public class MemberController {

    private final MemberService memberService;

    //회원가입
    @GetMapping("/signup")
    public String signup(UserInsertForm userInsertForm) {
        return "/member/signupForm";
    }

    //회원가입
//    @PostMapping("/signup")
//    public String signup(@Valid UserInsertForm userInsertForm, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "/member/signupForm";
//        }
//        if (!userInsertForm.getPassword1().equals(userInsertForm.getPassword2())) {
//            bindingResult.rejectValue("password2", "passwordInCorrect", "비밀번호가 일치하지 않습니다.");
//            return "/member/signupForm";
//        }
//        try {
//            System.out.println("check : "+userInsertForm.getUserId());
//            System.out.println("check : "+userInsertForm.getPassword1());
//            System.out.println("check : "+userInsertForm.getPassword2());
//            System.out.println("check : "+userInsertForm.getNickname());
//            System.out.println("check : "+userInsertForm.getEmail());
//
//            memberService.insertMember(userInsertForm.getUserId(), userInsertForm.getNickname(), userInsertForm.getPassword1(), userInsertForm.getEmail());
//        } catch (DataIntegrityViolationException e) {
//            e.printStackTrace();
//            bindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");
//            return "/member/signupForm";
//        } catch (Exception e) {
//            e.printStackTrace();
//            bindingResult.reject("signupFailed", e.getMessage());
//            return "/member/signupForm";
//        }
//        return "redirect:/";
//    }

    @PostMapping("/signup")
    public String signup(@Valid UserInsertForm userInsertForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("안됨______________");
            return "/member/signupForm";
        }
        if (!userInsertForm.getPassword1().equals(userInsertForm.getPassword2())) {
            bindingResult.rejectValue("password2", "passwordInCorrect", "2개의 패스워드가 일치하지 않습니다.");
            return "/member/signupForm";
        }
        try {
            memberService.insertMember(userInsertForm.getUsername(), userInsertForm.getNickname(), userInsertForm.getEmail(), userInsertForm.getPassword1());
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");
            return "/member/signupForm";
        } catch (Exception e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", e.getMessage());
            return "/member/signupForm";
        }

        return "redirect:/";
    }


    //로그인 (PostMapping 메서드는 스프링 시큐리티가 대신 처리하므로 직접 구현x)
    @GetMapping("/login")
    public String login() {
        return "/member/loginForm";
    }
}
