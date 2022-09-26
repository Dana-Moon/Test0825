package org.example.testAugust.member;

import lombok.RequiredArgsConstructor;
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

    @GetMapping("/signup")
    public String signup(UserInsertForm userInsertForm) {
        return "/member/signupForm";
    }
    @PostMapping("/signup")
    public String signup(@Valid UserInsertForm userInsertForm, BindingResult bindingResult, OppuMember oppuMember) {
        if (bindingResult.hasErrors()) {
            return "/member/signupForm";
        }
        if (!userInsertForm.getPassword1().equals(userInsertForm.getPassword2())) {
            bindingResult.rejectValue("password2", "passwordInCorrect", "비밀번호가 일치하지 않습니다.");
            return "/member/signupForm";
        }
        memberService.insertMember(oppuMember);

        return "redirect:/";
    }
}
