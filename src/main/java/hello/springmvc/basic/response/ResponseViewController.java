package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1() {
        ModelAndView mav = new ModelAndView("response/hello")
                .addObject("data", "hello");
        return mav;
    }

    @RequestMapping("/response-view-v2") // 제일 적당한 방법으로 추천.
    public String responseViewV2(Model model) { //String으로 반환하면, Model이 필요하다
        model.addAttribute("data", "hello!");
        return "response/hello"; //view의 논리적인 이름
    }

    @RequestMapping("/response/hello") //불명확해서 권장하지 않는다.
    public void responseViewV3(Model model) {
        model.addAttribute("data", "hello!");
    }
}
