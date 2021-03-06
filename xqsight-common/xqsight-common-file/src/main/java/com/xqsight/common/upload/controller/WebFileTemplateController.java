package com.xqsight.common.upload.controller;

import com.xqsight.common.upload.handler.FileHandler;
import com.xqsight.common.upload.support.UploadSupport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * WebFileController
 *
 * @author wangganggang
 */
@Controller
@RequestMapping("/files/template/web_file_1")
public class WebFileTemplateController extends WebFileControllerAbstractor {

    @Override
    protected int getType() {
        return TEMPLATE;
    }

    @Override
    protected String getBase() {
        return "";
    }

    @Override
    protected String getDefPath() {
        return getBase() + "/default";
    }

    @Override
    protected String getUrlPrefix() {
        return "";
    }

    @Override
    protected FileHandler getFileHandler() {
        return uploadSupport.getFileHandler(pathResolver);
    }

    @Override
    protected boolean isFtp() {
        return false;
    }

    @RequestMapping("left")
    @Override
    public String left(HttpServletRequest request, HttpServletResponse response, Model modelMap) throws IOException {
        String theme = "default";
        modelMap.addAttribute("theme", theme);
        return super.left(request, response, modelMap);
    }

    @RequestMapping("left_tree")
    @Override
    public String leftTree(HttpServletRequest request, HttpServletResponse response, Model modelMap) throws IOException {
        return super.leftTree(request, response, modelMap);
    }

    @RequestMapping("list")
    @Override
    public String list(HttpServletRequest request, HttpServletResponse response, Model modelMap) throws IOException {
        return super.list(request, response, modelMap);
    }

    @RequestMapping("create")
    @Override
    public String create(HttpServletRequest request, HttpServletResponse response, Model modelMap) throws IOException {
        return super.create(request, response, modelMap);
    }

    @RequestMapping("edit")
    @Override
    public String edit(HttpServletRequest request, HttpServletResponse response, Model modelMap) throws IOException {
        return super.edit(request, response, modelMap);
    }

    @RequestMapping(value = "mkdir", method = RequestMethod.POST)
    @Override
    public String mkdir(String parentId, String dir,
                        HttpServletRequest request, HttpServletResponse response,
                        RedirectAttributes ra) throws IOException {
        return super.mkdir(parentId, dir, request, response, ra);
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    @Override
    public String save(String parentId, String name, String text,
                       String redirect, HttpServletRequest request,
                       HttpServletResponse response, RedirectAttributes ra) throws IOException {
        return super.save(parentId, name, text, redirect, request, response, ra);
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    @Override
    public void update(String parentId, String origName, String name,
                       String text, Integer position, String redirect,
                       HttpServletRequest request, HttpServletResponse response) throws IOException {
        super.update(parentId, origName, name, text, position, redirect,
                request, response);
    }

    @RequestMapping("delete")
    @Override
    public String delete(HttpServletRequest request, HttpServletResponse response, RedirectAttributes ra) throws IOException {
        return super.delete(request, response, ra);
    }

    @RequestMapping("rename")
    @Override
    public String rename(HttpServletRequest request, HttpServletResponse response, RedirectAttributes ra) throws IOException {
        return super.rename(request, response, ra);
    }

    @RequestMapping("move")
    @Override
    public String move(HttpServletRequest request, HttpServletResponse response, RedirectAttributes ra) throws IOException {
        return super.move(request, response, ra);
    }

    @RequestMapping("zip")
    @Override
    public String zip(HttpServletRequest request, HttpServletResponse response, RedirectAttributes ra) throws IOException {
        return super.zip(request, response, ra);
    }

    @RequestMapping("zip_download")
    @Override
    public void zipDownload(HttpServletRequest request, HttpServletResponse response, RedirectAttributes ra) throws IOException {
        super.zipDownload(request, response, ra);
    }

    @RequestMapping("unzip")
    @Override
    public String unzip(HttpServletRequest request, HttpServletResponse response, RedirectAttributes ra) throws IOException {
        return super.unzip(request, response, ra);
    }

    @RequestMapping("upload")
    @Override
    public void upload(@RequestParam(value = "file", required = false) MultipartFile file,
                       HttpServletRequest request, HttpServletResponse response)
            throws IllegalStateException, IOException {
        super.upload(file, request, response);
    }

    @RequestMapping("zip_upload")
    @Override
    public void zipUpload(@RequestParam(value = "file", required = false) MultipartFile file,
                          HttpServletRequest request, HttpServletResponse response,
                          RedirectAttributes ra) throws IOException {
        super.zipUpload(file, request, response, ra);
    }

    @Override
    protected String dir(HttpServletRequest request, HttpServletResponse response, Model modelMap) throws IOException {
        return super.dir(request, response, modelMap);
    }

    @RequestMapping("choose_dir_list")
    @Override
    public String dirList(HttpServletRequest request, HttpServletResponse response, Model modelMap) throws IOException {
        return super.dirList(request, response, modelMap);
    }
}
