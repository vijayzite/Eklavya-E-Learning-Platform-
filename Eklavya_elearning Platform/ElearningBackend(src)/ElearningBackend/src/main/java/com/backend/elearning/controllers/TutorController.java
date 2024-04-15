//package com.backend.elearning.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import com.backend.elearning.models.*;
//
//import com.backend.elearning.services.ApproveService;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//public class TutorController {
//
//    @Autowired
//    private ApproveService approveService;
//
//    @PostMapping("/instructor/getapprove")
//    public String getApprove(@RequestBody Approve approve) {
//        approveService.save(approve);
//        return "Your request submitted for approval.";
//    }
//
//    @GetMapping("/admin/approve/instructor")
//    public List<ApproveData> getApproveList() {
//        System.out.println("in call");
//
//        List<ApproveData> dataList = new ArrayList<>();
//
//        List<Approve> approveList = approveService.getApproveListByUserID();
//
//        for (Approve approve : approveList) {
//            ApproveData data = new ApproveData();
//
//            data.setApvId(approve.getApvId());
//            data.setCerti(approve.getCerti());
//            data.setDesc(approve.getDesc());
//            data.setQualification(approve.getQualification());
//            data.setExp(approve.getExp());
//            data.setStatus(approve.getStatus());
//            data.setUiId(approve.getUiId());
//
//            dataList.add(data);
//        }
//
//        return dataList;
//    }
//}
