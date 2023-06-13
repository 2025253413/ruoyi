package com.ruoyi.system.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SysUserRole;
import com.ruoyi.system.service.ISysUserRoleService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户和角色关联Controller
 * 
 * @author ruoyi
 * @date 2023-06-09
 */
@Controller
@RequestMapping("/system/role")
public class SysUserRoleController extends BaseController
{
    private String prefix = "system/role";

    @Autowired
    private ISysUserRoleService sysUserRoleService;

    @RequiresPermissions("system:role:view")
    @GetMapping()
    public String role()
    {
        return prefix + "/role";
    }

    /**
     * 查询用户和角色关联列表
     */
    @RequiresPermissions("system:role:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysUserRole sysUserRole)
    {
        startPage();
        List<SysUserRole> list = sysUserRoleService.selectSysUserRoleList(sysUserRole);
        return getDataTable(list);
    }

    /**
     * 导出用户和角色关联列表
     */
    @RequiresPermissions("system:role:export")
    @Log(title = "用户和角色关联", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysUserRole sysUserRole)
    {
        List<SysUserRole> list = sysUserRoleService.selectSysUserRoleList(sysUserRole);
        ExcelUtil<SysUserRole> util = new ExcelUtil<SysUserRole>(SysUserRole.class);
        return util.exportExcel(list, "用户和角色关联数据");
    }

    /**
     * 新增用户和角色关联
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存用户和角色关联
     */
    @RequiresPermissions("system:role:add")
    @Log(title = "用户和角色关联", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysUserRole sysUserRole)
    {
        return toAjax(sysUserRoleService.insertSysUserRole(sysUserRole));
    }

    /**
     * 修改用户和角色关联
     */
    @RequiresPermissions("system:role:edit")
    @GetMapping("/edit/{userId}")
    public String edit(@PathVariable("userId") Long userId, ModelMap mmap)
    {
        SysUserRole sysUserRole = sysUserRoleService.selectSysUserRoleByUserId(userId);
        mmap.put("sysUserRole", sysUserRole);
        return prefix + "/edit";
    }

    /**
     * 修改保存用户和角色关联
     */
    @RequiresPermissions("system:role:edit")
    @Log(title = "用户和角色关联", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysUserRole sysUserRole)
    {
        return toAjax(sysUserRoleService.updateSysUserRole(sysUserRole));
    }

    /**
     * 删除用户和角色关联
     */
    @RequiresPermissions("system:role:remove")
    @Log(title = "用户和角色关联", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysUserRoleService.deleteSysUserRoleByUserIds(ids));
    }
}
