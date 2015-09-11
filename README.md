# JavaSecurity
java 加密 解密


C:\Users\Administrator>keytool -genkey -validity 360 -alias loon -keyalg RSA -keystore c:\loon.keystore
输入密钥库口令:
密钥库口令太短 - 至少必须为 6 个字符
输入密钥库口令:
再次输入新口令:
您的名字与姓氏是什么?
  [Unknown]:  loon
您的组织单位名称是什么?
  [Unknown]:  loon
您的组织名称是什么?
  [Unknown]:  loon
您所在的城市或区域名称是什么?
  [Unknown]:  shanghai
您所在的省/市/自治区名称是什么?
  [Unknown]:  shanghai
该单位的双字母国家/地区代码是什么?
  [Unknown]:  CN
CN=loon, OU=loon, O=loon, L=shanghai, ST=shanghai, C=CN是否正确?
  [否]:  Y

输入 <loon> 的密钥口令




C:\Users\Administrator>keytool -export -keystore c:\loon.keystore  -alias loon -file c:\loon.cer -rfc
输入密钥库口令:
存储在文件 <c:\loon.cer> 中的证书



