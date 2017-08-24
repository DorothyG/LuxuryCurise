/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.curise.controller.mana.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import team.curise.entity.UserRole;
import team.curise.entity.service.UserRoleService;
import team.curise.json.entity.CreditOfDiffRank;
import team.curise.json.entity.RealNameInfo;
import team.curise.util.MapUtil;

/**
 *
 * @author pupu
 */
@Service
public class InfoService {

    @Resource
    private UserRoleService userRoleService;
    @Resource
    private ManaBaseService manaBaseService;

    private Map<String, Integer> creditOfAgeMap = new HashMap<>();
    private Map<String, Integer> creditOfOccupMap = new HashMap<>();
    private Map<String, Integer> creditOfSexMap = new HashMap<>();

    private List<CreditOfDiffRank> allCreditOfDiffAge = new ArrayList<>();
    private List<RealNameInfo> allRealNameInfoOfDiffAge = new ArrayList<>();

    private Map<String, Integer> occupNumMap = new TreeMap<>();

    //选择一个职业，返回这个职业的信用的情况
    public CreditOfDiffRank getCreditByOccup(int curise_id, String occup) {
        List<Integer> userIds = manaBaseService.getAllUserIdByCuriseId(curise_id);
        int[] numOfDiffCredit = {0, 0, 0, 0, 0};

        for (Integer user_id : userIds) {
            List r = userRoleService.find("select credit from UserRole where id=? and occupation=?", user_id, occup);
            if (r.size() == 1) {
                String credit = (String) r.get(0);
                setCreditInfo(credit, numOfDiffCredit);
            }
        }
        CreditOfDiffRank codr = new CreditOfDiffRank(numOfDiffCredit);
        return codr;
    }

    //选择一种性别，返回这个性别的信用度情况
    public CreditOfDiffRank getCreditBySex(int curise_id, String sexStr) {
        int[] numOfDiffCredit = {0, 0, 0, 0, 0};
        int sex;
        if (sexStr.equals("女")) {
            sex = 1;
        } else {
            sex = 2;
        }
        List<Integer> userIds = manaBaseService.getAllUserIdByCuriseId(curise_id);
        for (Integer user_id : userIds) {
            List r = userRoleService.find("select credit from UserRole where id=? and sex=?", user_id, sex);
            if (r.size() == 1) {
                String credit = (String) r.get(0);
                setCreditInfo(credit, numOfDiffCredit);
            }
        }
        CreditOfDiffRank codr = new CreditOfDiffRank(numOfDiffCredit);
        return codr;
    }

    //选择一个年龄段，返回这个年龄段的信用度情况
    public CreditOfDiffRank getCreditByAge(int curise_id, String ageStr) {
        initCreditOfAge(curise_id, ageStr);
        if (ageStr.equals("童年")) {
            return allCreditOfDiffAge.get(0);
        } else if (ageStr.equals("少年")) {
            return allCreditOfDiffAge.get(1);
        } else if (ageStr.equals("青年")) {
            return allCreditOfDiffAge.get(2);
        } else if (ageStr.equals("中年")) {
            return allCreditOfDiffAge.get(3);
        } else if (ageStr.equals("老年")) {
            return allCreditOfDiffAge.get(4);
        }
        return null;
    }

    //选择总体，返回这艘邮轮总的用户信用度情况
    public CreditOfDiffRank getAllCredit(int curise_id) {
        int[] numOfDffCredit = {0, 0, 0, 0, 0};
        List<Integer> userIds = manaBaseService.getAllUserIdByCuriseId(curise_id);
        for (Integer user_id : userIds) {
            List r = userRoleService.find("select credit from UserRole where id=? ", user_id);
            if (r.size() == 1) {
                String credit = (String) r.get(0);
                setCreditInfo(credit, numOfDffCredit);
            }
        }
        CreditOfDiffRank codr = new CreditOfDiffRank(numOfDffCredit);
        return codr;
    }

    //初始化各个年龄阶段的信用度情况
    public void initCreditOfAge(int curise_id, String ageStr) {
        List<Integer> userIds = manaBaseService.getAllUserIdByCuriseId(curise_id);
        int[] creditChild = {0, 0, 0, 0, 0};
        int[] creditEarlyYouth = {0, 0, 0, 0, 0};
        int[] creditYouth = {0, 0, 0, 0, 0};
        int[] creditMidLife = {0, 0, 0, 0, 0};
        int[] creditOld = {0, 0, 0, 0, 0};
        for (Integer user_id : userIds) {
            List r = userRoleService.find("select credit,age from UserRole where id=?", user_id);
            if (r.size() == 1) {
                Object[] obj = (Object[]) r.get(0);
                String credit = (String) obj[0];
                int age = (int) obj[1];

                if (age <= 6) {
                    setCreditInfo(credit, creditChild);
                } else if (age <= 17) {
                    setCreditInfo(credit, creditEarlyYouth);
                } else if (age <= 40) {
                    setCreditInfo(credit, creditYouth);
                } else if (age <= 65) {
                    setCreditInfo(credit, creditMidLife);
                } else {
                    setCreditInfo(credit, creditOld);
                }
            }
        }
        CreditOfDiffRank codrChild = new CreditOfDiffRank(creditChild);
        CreditOfDiffRank codrEarlyYouth = new CreditOfDiffRank(creditEarlyYouth);
        CreditOfDiffRank codrYouth = new CreditOfDiffRank(creditYouth);
        CreditOfDiffRank codrMidLife = new CreditOfDiffRank(creditMidLife);
        CreditOfDiffRank codrOld = new CreditOfDiffRank(creditOld);

        allCreditOfDiffAge.add(codrChild);
        allCreditOfDiffAge.add(codrEarlyYouth);
        allCreditOfDiffAge.add(codrYouth);
        allCreditOfDiffAge.add(codrMidLife);
        allCreditOfDiffAge.add(codrOld);

    }

    //根据credit设置各个等级信用度情况
    public void setCreditInfo(String credit, int[] numOfDiffCredit) {
        if (credit.equals("A")) {
            numOfDiffCredit[0]++;
        } else if (credit.equals("B")) {
            numOfDiffCredit[1]++;
        } else if (credit.equals("C")) {
            numOfDiffCredit[2]++;
        } else if (credit.equals("D")) {
            numOfDiffCredit[3]++;
        } else if (credit.equals("E")) {
            numOfDiffCredit[4]++;
        }
    }

    //选择具体的职业，得到该职业的实名认证和未实名认证人数
    public RealNameInfo getRealNameNumByOccup(int curise_id, String occup) {
        int[] realNameInfos = {0, 0};
        List<Integer> userIds = manaBaseService.getAllUserIdByCuriseId(curise_id);
        for (Integer user_id : userIds) {
            List r = userRoleService.find("select real_name from UserRole where id=? and occupation=?", user_id, occup);
            if (r.size() == 1) {
                String real_name = (String) r.get(0);
                setRealNameInfo(real_name, realNameInfos);
            }
        }
        RealNameInfo realNameInfo = new RealNameInfo(realNameInfos);
        return realNameInfo;
    }

    //选择性别，得到该性别对应的实名认证和未实名认证的人数
    public RealNameInfo getRealNameNumBySex(int curise_id, String sexStr) {
        int sex;
        int[] realNameInfos = {0, 0};
        if (sexStr.equals("女")) {
            sex = 1;
        } else {
            sex = 2;
        }
        List<Integer> userIds = manaBaseService.getAllUserIdByCuriseId(curise_id);
        for (Integer user_id : userIds) {
            List r = userRoleService.find("select real_name from UserRole where id=? and sex=?", user_id, sex);
            if (r.size() == 1) {
                String real_name = (String) r.get(0);
                setRealNameInfo(real_name, realNameInfos);
            }
        }
        RealNameInfo realNameInfo = new RealNameInfo(realNameInfos);
        return realNameInfo;
    }

    //选择年龄段，得到该年龄段的实名认证和未实名认证的人数
    public RealNameInfo getRealNameNumByAge(int curise_id, String ageStr) {
        initRealNameOfAge(curise_id, ageStr);
        if (ageStr.equals("童年")) {
            return allRealNameInfoOfDiffAge.get(0);
        } else if (ageStr.equals("少年")) {
            return allRealNameInfoOfDiffAge.get(1);
        } else if (ageStr.equals("青年")) {
            return allRealNameInfoOfDiffAge.get(2);
        } else if (ageStr.equals("中年")) {
            return allRealNameInfoOfDiffAge.get(3);
        } else if (ageStr.equals("老年")) {
            return allRealNameInfoOfDiffAge.get(4);
        }
        return null;
    }

    //选择总表，得到该邮轮的全部用户的实名认证和未实名认证的人数
    public RealNameInfo getAllRealName(int curise_id) {
        List<Integer> userIds = manaBaseService.getAllUserIdByCuriseId(curise_id);

        int[] realNameInfos = {0, 0};
        for (Integer user_id : userIds) {
            List r = userRoleService.find("select real_name from UserRole where id=? ", user_id);
            if (r.size() == 1) {
                String real_name = (String) r.get(0);
                setRealNameInfo(real_name, realNameInfos);
            }
        }
        RealNameInfo realNameInfo = new RealNameInfo(realNameInfos);
        return realNameInfo;
    }

    //初始化该邮轮的各个年龄段用户的实名认证情况
    public void initRealNameOfAge(int curise_id, String ageStr) {
        int[] realNameInfosChild = {0, 0};
        int[] realNameInfosEarlyYouth = {0, 0};
        int[] realNameInfosYouth = {0, 0};
        int[] realNameInfosMidLife = {0, 0};
        int[] realNameInfosOld = {0, 0};

        List<Integer> userIds = manaBaseService.getAllUserIdByCuriseId(curise_id);
        for (Integer user_id : userIds) {
            List r = userRoleService.find("select real_name,age from UserRole where id=?", user_id);
            if (r.size() == 1) {
                Object[] obj = (Object[]) r.get(0);
                String real_name = (String) obj[0];
                int age = (int) obj[1];

                if (age <= 6) {
                    setRealNameInfo(real_name, realNameInfosChild);
                } else if (age <= 17) {
                    setRealNameInfo(real_name, realNameInfosEarlyYouth);
                } else if (age <= 40) {
                    setRealNameInfo(real_name, realNameInfosYouth);
                } else if (age <= 65) {
                    setRealNameInfo(real_name, realNameInfosMidLife);
                } else {
                    setRealNameInfo(real_name, realNameInfosOld);
                }
            }
        }
        RealNameInfo realNameInfoChild = new RealNameInfo(realNameInfosChild);
        RealNameInfo realNameInfoEarlyYouth = new RealNameInfo(realNameInfosEarlyYouth);
        RealNameInfo realNameInfoYouth = new RealNameInfo(realNameInfosYouth);
        RealNameInfo realNameInfoMidlife = new RealNameInfo(realNameInfosMidLife);
        RealNameInfo realNameInfoOld = new RealNameInfo(realNameInfosOld);

        allRealNameInfoOfDiffAge.add(realNameInfoChild);
        allRealNameInfoOfDiffAge.add(realNameInfoEarlyYouth);
        allRealNameInfoOfDiffAge.add(realNameInfoYouth);
        allRealNameInfoOfDiffAge.add(realNameInfoMidlife);
        allRealNameInfoOfDiffAge.add(realNameInfoOld);
    }

    //根据realname的情况设置实名认证和未实名认证的人数
    public void setRealNameInfo(String real_name, int[] realNameInfo) {
        if (real_name == null) {
            realNameInfo[0]++;
        } else {
            realNameInfo[1]++;
        }
    }
    
     //获得实名制年龄段分的人数
    public Map<String,Integer> getNumOfDiffAge(int curise_id){
        Map<String,Integer> result = new HashMap<>();
        List<Integer> userIds = manaBaseService.getAllUserIdByCuriseId(curise_id);
        int numChild=0;
        int numEarlyYouth =0;
        int numYouth=0;
        int numMidLife=0;
        int numOld=0;
        for (Integer user_id : userIds) {
             UserRole r = (UserRole) userRoleService.find("from UserRole where id=?", user_id).get(0);
            if(r.getReal_name()!=null){
                int age = r.getAge();
                if (age <= 6) {
                    numChild++;
                } else if (age <= 17) {
                    numEarlyYouth++;
                } else if (age <= 40) {
                    numYouth++;
                } else if (age <= 65) {
                    numMidLife++;
                } else {
                    numOld++;
                }
            }
        }
        result.put("童年",numChild);
        result.put("少年",numEarlyYouth);
        result.put("青年",numYouth);
        result.put("中年",numMidLife);
        result.put("老年",numOld);
        
        return result;
    }
    
    //获得实名制男女的人数
    public Map<String,Integer> getNumOfDiffSex(int curise_id){
        Map<String,Integer> result = new HashMap<>();
        List<Integer> userIds = manaBaseService.getAllUserIdByCuriseId(curise_id);
        int numMale=0;
        int numFemale =0;
        for (Integer user_id : userIds) {
            UserRole r = (UserRole) userRoleService.find("from UserRole where id=?", user_id).get(0);
            if(r.getReal_name()!=null){
                if(r.getSex()==1){
                    numFemale++;
                }else{
                    numMale++;
                }
            }
        }
        result.put("男", numMale);
        result.put("女", numFemale);
        return result;
    }
    
    //获得实名制的人数排前四个的人数，前四个职业，剩下的都是其他
    public Map<String, Integer> getNumOfDiffOccup(int curise_id) {
        Map<String, Integer> result = new HashMap<>();
        initAllOccup(curise_id);
       ArrayList<Map.Entry<String, Integer>> entries = MapUtil.sortByValue(occupNumMap);
        for (int i = 0; i <entries.size() ; i++) {
            System.out.print(entries.get(i).getKey() + ":" + entries.get(i).getValue()+",,,");
        }
        int otherNum = 0;
        for (int i=0;i<entries.size();i++) {
            if (i < 4) {
                result.put(entries.get(i).getKey(), entries.get(i).getValue());
            } else {
                otherNum+=entries.get(i).getValue();
            }
        }
        result.put("其他职业", otherNum);
        return result;
    }


    //初始化职业，初始化每个职业的不实名的人数
    public void initAllOccup(int curise_id) {
        List<Integer> userIds = manaBaseService.getAllUserIdByCuriseId(curise_id);
        for (Integer user_id : userIds) {
//            System.out.println("user_id:"+user_id);
            UserRole r = (UserRole) userRoleService.find("from UserRole where id=?", user_id).get(0);

            String occup = r.getOccupation();
            String real_name = r.getReal_name();
            if (occupNumMap.containsKey(occup)) {
                if (real_name != null) {
                    int num = occupNumMap.get(occup);
                    num++;
                    occupNumMap.put(occup, num);
                }
            } else {
                if (real_name != null) {
                    occupNumMap.put(occup, 1);
                }else {
                    occupNumMap.put(occup, 0);
                }
            }
        }
    }
    //初始化职业
    public void initAllOccupTwo(int curise_id, List<String> occupList) {
        List<Integer> userIds = manaBaseService.getAllUserIdByCuriseId(curise_id);
        for (Integer user_id : userIds) {
//            System.out.println("user_id:"+user_id);
            List r = userRoleService.find("select occupation from UserRole where id=?", user_id);
            if (r.size() == 1) {
                String occup = (String) r.get(0);
                if (!occupList.contains(occup)) {
                    occupList.add(occup);
                } 
            }
        }
    }
    
}
