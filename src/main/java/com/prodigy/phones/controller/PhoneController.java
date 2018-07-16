package com.prodigy.phones.controller;


import com.prodigy.phones.model.Feedback;
import com.prodigy.phones.to.SearchName;
import com.prodigy.phones.model.Phone;
import com.prodigy.phones.model.Subdivision;
import com.prodigy.phones.model.Vessel;
import com.prodigy.phones.service.PhoneService;
import com.prodigy.phones.utils.SendMail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class PhoneController {

    private static final Logger log = LoggerFactory.getLogger(PhoneController.class);

    @Autowired
    private PhoneService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(HttpServletRequest request, Model model) {

        log.info("Request came from {}", request.getRemoteAddr());

        List<Phone> phoneList = service.getAllPhones();
        List<Subdivision> subdivisionList = service.getSubdivisions();
        List<Subdivision> subdivisionsByParentId = service.getSubdivisionsByParentId(1000);

        int phones = phoneList.size();
        int leftPanelDeps = 0;
        int leftPhones = 0;
        for (Subdivision s : subdivisionsByParentId) {
            if (leftPhones < (phones / 2)) {
                leftPanelDeps++;
            } else {
                leftPanelDeps -= 6;
                break;
            }

            leftPhones += phoneList.stream()
                    .filter(p -> p.getSubdivision().getId().equals(s.getId()))
                    .count();

        }

        int rightPanelDeps = subdivisionsByParentId.size() - leftPanelDeps;
        List<Subdivision> leftDepList = subdivisionsByParentId.subList(0, leftPanelDeps);
        List<Subdivision> rightDepList = subdivisionsByParentId.subList(leftPanelDeps, subdivisionsByParentId.size());

        model.addAttribute("phoneList", phoneList);
        model.addAttribute("subdivisionList", subdivisionList);
        model.addAttribute("leftDepList", leftDepList);
        model.addAttribute("rightDepList", rightDepList);
        model.addAttribute("office", true);
        model.addAttribute("topSubdivisions", service.getTopSubdivisions());
        model.addAttribute("officeList", subdivisionsByParentId);


        return "index";
    }

    @RequestMapping(value = "{id}")
    public String getSubdivision(@PathVariable("id") Integer id, HttpServletRequest request, Model model) {

        if (id.equals(1000)) {
            return "redirect:/";
        }

        log.info("Request came from {}", request.getRemoteAddr());

        List<Phone> phoneList = service.getAllPhones();
        List<Subdivision> subdivisionList = service.getSubdivisions();

        model.addAttribute("leftDepList", service.getSubdivisionsById(id));
        model.addAttribute("phoneList", phoneList);
        model.addAttribute("subdivisionList", subdivisionList);
        model.addAttribute("topSubdivisions", service.getTopSubdivisions());
        model.addAttribute("officeList", service.getSubdivisionsByParentId(1000));

        return "index";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(@ModelAttribute("userName") SearchName userName, HttpServletRequest request, Model model) {

        log.info("Request '{}' came from {}", userName, request.getRemoteAddr());

        if ("".equals(userName.getName())) {
            userName.setName("empty");
        }

        List<Phone> phoneList = service.getAllPhones();
        List<Phone> phones = service.searchByName(userName.getName());
        Set<Subdivision> subdivisionList = phones.stream()
                .map(p -> p.getSubdivision())
                .collect(Collectors.toSet());

        model.addAttribute("searchDepList", subdivisionList);
        model.addAttribute("phoneList", phoneList);
        model.addAttribute("phones", phones);
        model.addAttribute("search", true);
        model.addAttribute("subdivisionList", service.getSubdivisions());
        model.addAttribute("office", true);
        model.addAttribute("topSubdivisions", service.getTopSubdivisions());
        model.addAttribute("officeList", service.getSubdivisionsByParentId(1000));

        return "index";
    }

    @RequestMapping(value = "/vessels")
    public String vessels(Model model) {

        model.addAttribute("vesselList", service.getAllVessels());

        return "vessels";
    }

    @RequestMapping(value = "/feedback")
    public String feedback(Model model){

        model.addAttribute("newFeedback", new Feedback());

        return "feedback";
    }

    @RequestMapping(value = "/sendFeedback")
    public String sendFeedback(@ModelAttribute("newFeedback") Feedback feedback, Model model){

        boolean isSuccess = SendMail.send(feedback.getText());

        model.addAttribute("isSuccess", isSuccess);
        model.addAttribute("isFailure", !isSuccess);
        model.addAttribute("newFeedback", new Feedback());

        return "feedback";
    }

}
