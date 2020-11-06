package com.kgc.controller;

import com.github.pagehelper.PageInfo;
import com.kgc.entity.Collage;
import com.kgc.entity.Condition;
import com.kgc.entity.Major;
import com.kgc.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("major")
public class MajorController {

    @Autowired
    private MajorService majorService;

    @RequestMapping("list")
    public ModelAndView list(Condition condition, @RequestParam(value="page",required = false,defaultValue ="1") Integer pageNum, HttpSession session,ModelAndView mv){
        PageInfo pageInfo = majorService.findByCondition(condition, pageNum,5);
        List<Collage> collageList = majorService.findAll();
        mv.addObject("pageInfo",pageInfo);
        session.setAttribute("collageList",collageList);

        mv.setViewName("main");
        return mv;
    }

    @RequestMapping("toAddMajor")
    public String toAddMajor(){
        return "addMajor";
    }

    @RequestMapping("addMajor")
    public ModelAndView addMajor(Major major, ModelAndView mv){
        majorService.insert(major);
        mv.addObject("insert","success");
        /*if (1){
            mv.addObject("insert","success");
        }else {
            mv.addObject("insert","fail");
        }*/
        mv.setViewName("forward:list");
        return mv;
    }

    @RequestMapping("toUpdateMajor")
    public String toUpdateMajor(Integer mid, Model model){
        Major major = majorService.selectByPrimaryKey(mid);
        model.addAttribute("major",major);
        return "updateMajor";
    }

    @RequestMapping("updateMajor")
    public ModelAndView updateMajor(Major major,ModelAndView mv){
        majorService.updateByPrimaryKeySelective(major);
        mv.addObject("update","success");
        /*if (b){
            mv.addObject("update","success");
        }else {
            mv.addObject("update","fail");
        }*/
        mv.setViewName("forward:list");
        return mv;
    }

    @RequestMapping("findMajor")
    public String findMajor(Integer mid, Model model){
        Major major = majorService.selectByPrimaryKey(mid);
        model.addAttribute("major",major);
        return "detailMajor";
    }


    @RequestMapping("detailMajor")
    public ModelAndView detailMajor(Major major,ModelAndView mv){
        majorService.updateByPrimaryKeySelective(major);
        mv.setViewName("forward:list");
        return mv;
    }

    @RequestMapping("deleteMajor")
    public ModelAndView deleteMajor(Integer mid,ModelAndView mv){
        majorService.deleteByPrimaryKey(mid);
        mv.addObject("delete","success");
        /*if (b){
            mv.addObject("delete","success");
        }else {
            mv.addObject("delete","fail");
        }*/
        mv.setViewName("forward:list");
        return mv;
    }
}
