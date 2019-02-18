package com.fei.springboot.util;

import com.fei.springboot.domain.SysRegionEntity;
import org.java_websocket.WebSocketImpl;
import org.springframework.beans.factory.InitializingBean;

import java.net.UnknownHostException;
import java.util.*;

/**
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-11-04 11:19:31
 */
public class RegionCacheUtil implements InitializingBean {

    public static List<SysRegionEntity> sysRegionEntityList;

    public static void init() {
        /*SysRegionDao regionDao = SpringContextUtils.getBean(SysRegionDao.class);
        if (null != regionDao) {
            sysRegionEntityList = regionDao.queryList(new HashMap<String, Object>());
        }*/
        System.out.println("地市数据初始化。。。");
    }

    //计时器
    public void timer() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 9); // 控制时
        calendar.set(Calendar.MINUTE, 0); 		// 控制分
        calendar.set(Calendar.SECOND, 0); 		// 控制秒

        Date time = calendar.getTime(); 		// 得出执行任务的时间

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {

                //PersonService personService = (PersonService)ApplicationContext.getBean("personService");


                //System.out.println("-------设定要指定任务--------");
            }
        }, time, 1000*60*60*24);// 这里设定将延时每天固定执行
    }
    /**
     * 获取所有国家
     *
     * @return
     */
    public static List<SysRegionEntity> getAllCountry() {
        List<SysRegionEntity> resultObj = new ArrayList<SysRegionEntity>();
        if (null != sysRegionEntityList) {
            for (SysRegionEntity areaVo : sysRegionEntityList) {
                if (areaVo.getType().equals(0)) {
                    resultObj.add(areaVo);
                }
            }
        }
        return resultObj;
    }

    /**
     * 获取全部省份
     *
     * @return
     */
    public static List<SysRegionEntity> getAllProvice() {
        List<SysRegionEntity> resultObj = new ArrayList<SysRegionEntity>();
        if (null != sysRegionEntityList) {
            for (SysRegionEntity areaVo : sysRegionEntityList) {
                if (areaVo.getType().equals(1)) {
                    resultObj.add(areaVo);
                }
            }
        }
        return resultObj;
    }

    /**
     * 获取所有城市
     *
     * @return
     */
    public static List<SysRegionEntity> getAllCity() {
        List<SysRegionEntity> resultObj = new ArrayList<SysRegionEntity>();
        if (null != sysRegionEntityList) {
            for (SysRegionEntity areaVo : sysRegionEntityList) {
                if (areaVo.getType().equals(2)) {
                    resultObj.add(areaVo);
                }
            }
        }
        return resultObj;
    }

    /**
     * 根据国家获取全部省份
     *
     * @return
     */
    public static List<SysRegionEntity> getAllProviceByParentId(Integer areaId) {
        List<SysRegionEntity> resultObj = new ArrayList<SysRegionEntity>();
        if (null == areaId) {
            return resultObj;
        }
        if (null != sysRegionEntityList) {
            for (SysRegionEntity areaVo : sysRegionEntityList) {
                if (null != areaVo.getParentId() && areaVo.getType().equals(1) && areaId.equals(areaVo.getParentId())) {
                    resultObj.add(areaVo);
                }
            }
        }
        return resultObj;
    }

    /**
     * 获取地市
     *
     * @return
     */
    public static List<SysRegionEntity> getChildrenCity(Integer areaId) {
        List<SysRegionEntity> resultObj = new ArrayList<SysRegionEntity>();
        if (null == areaId) {
            return resultObj;
        }
        if (null != sysRegionEntityList) {
            for (SysRegionEntity areaVo : sysRegionEntityList) {
                if (null != areaVo.getParentId() && areaVo.getType().equals(2) && areaId.equals(areaVo.getParentId())) {
                    resultObj.add(areaVo);
                }
            }
        }
        return resultObj;
    }

    /**
     * 获取地市
     *
     * @return
     */
    public static List<SysRegionEntity> getChildrenCity(String proviceName) {
        List<SysRegionEntity> resultObj = new ArrayList<SysRegionEntity>();
        if (null == proviceName) {
            return resultObj;
        }
        if (null != sysRegionEntityList) {
            for (SysRegionEntity areaVo : sysRegionEntityList) {
                if (null != areaVo.getParentId() && areaVo.getType().equals(2) && proviceName.equals(areaVo.getParentName())) {
                    resultObj.add(areaVo);
                }
            }
        }
        return resultObj;
    }

    /**
     * 获取区县
     *
     * @return
     */
    public static List<SysRegionEntity> getChildrenDistrict(Integer areaId) {
        List<SysRegionEntity> resultObj = new ArrayList<SysRegionEntity>();
        if (null == areaId) {
            return resultObj;
        }
        if (null != sysRegionEntityList) {
            for (SysRegionEntity areaVo : sysRegionEntityList) {
                if (null != areaVo.getParentId() && areaVo.getType().equals(3) && areaId.equals(areaVo.getParentId())) {
                    resultObj.add(areaVo);
                }
            }
        }
        return resultObj;
    }

    /**
     * 获取区县
     *
     * @return
     */
    public static List<SysRegionEntity> getChildrenDistrict(String provinceName, String cityName) {
        List<SysRegionEntity> resultObj = new ArrayList<SysRegionEntity>();
        if (null == provinceName || null == cityName) {
            return resultObj;
        }
        if (null != sysRegionEntityList) {
            for (SysRegionEntity areaVo : sysRegionEntityList) {
                if (null != areaVo.getParentId() && areaVo.getType().equals(3)
                        && cityName.equals(areaVo.getParentName())
                        && null != getAreaByAreaId(areaVo.getParentId())
                        && provinceName.equals(getAreaByAreaId(areaVo.getParentId()).getParentName())) {
                    resultObj.add(areaVo);
                }
            }
        }
        return resultObj;
    }


    /**
     * 获取区县
     *
     * @return
     */
    public static List<SysRegionEntity> getChildrenByParentId(Integer parentId) {
        List<SysRegionEntity> resultObj = new ArrayList<SysRegionEntity>();
        if (null == parentId) {
            return resultObj;
        }
        if (null != sysRegionEntityList) {
            for (SysRegionEntity areaVo : sysRegionEntityList) {
                if (null != areaVo.getParentId() && parentId.equals(areaVo.getParentId())) {
                    resultObj.add(areaVo);
                }
            }
        }
        return resultObj;
    }

    /**
     * 获取区域名称
     *
     * @return
     */
    public static String getAreaNameByAreaId(Integer areaId) {
        if (null == areaId) {
            return "";
        }
        String resultObj = areaId.toString();
        if (null != sysRegionEntityList) {
            for (SysRegionEntity areaVo : sysRegionEntityList) {
                if (areaVo.getId().equals(areaId)) {
                    resultObj = areaVo.getName();
                    break;
                }
            }
        }
        return resultObj;
    }

    /**
     * 根据Id获取区域
     *
     * @return
     */
    public static SysRegionEntity getAreaByAreaId(Integer areaId) {
        SysRegionEntity resultObj = null;
        if (null == areaId) {
            return resultObj;
        }
        if (null != sysRegionEntityList) {
            for (SysRegionEntity areaVo : sysRegionEntityList) {
                if (areaVo.getId().equals(areaId)) {
                    resultObj = areaVo;
                    break;
                }
            }
        }
        return resultObj;
    }

    /**
     * 根据Id获取区域
     *
     * @return
     */
    public static Integer getProvinceIdByName(String areaName) {
        Integer resultObj = null;
        if (null == areaName) {
            return resultObj;
        }
        if (null != sysRegionEntityList) {
            for (SysRegionEntity areaVo : sysRegionEntityList) {
                if (areaVo.getType() == 1 && areaVo.getName().equals(areaName)) {
                    resultObj = areaVo.getId();
                    break;
                }
            }
        }
        return resultObj;
    }

    /**
     * 根据Id获取区域
     *
     * @return
     */
    public static Integer getCityIdByName(Integer provinceId, String areaName) {
        Integer resultObj = null;
        if (null == areaName) {
            return resultObj;
        }
        if (null != sysRegionEntityList) {
            for (SysRegionEntity areaVo : sysRegionEntityList) {
                if (areaVo.getType() == 2 && areaVo.getName().equals(areaName)
                        && areaVo.getParentId().equals(provinceId)) {
                    resultObj = areaVo.getId();
                    break;
                }
            }
        }
        return resultObj;
    }


    /**
     * 根据Id获取区域
     *
     * @return
     */
    public static Integer getDistrictIdByName(Integer provinceId, Integer cityId, String areaName) {
        Integer resultObj = null;
        if (null == areaName) {
            return resultObj;
        }
        if (null != sysRegionEntityList) {
            for (SysRegionEntity areaVo : sysRegionEntityList) {
                if (areaVo.getType() == 3 && areaVo.getName().equals(areaName)
                        && areaVo.getParentId().equals(cityId)
                        && null != getAreaByAreaId(areaVo.getParentId())
                        && null != getAreaByAreaId(areaVo.getParentId()).getParentId()
                        && getAreaByAreaId(areaVo.getParentId()).getParentId().equals(provinceId)) {
                    resultObj = areaVo.getId();
                    break;
                }
            }
        }
        return resultObj;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        init();
    }

}