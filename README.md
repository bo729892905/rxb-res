### 预案题实体类参数说明

| 参数名称 |    说明     |    类型    |    是否为主键    |
|---------|:-----------|:-----------|:------:|
| id       | 预案题ID   | String | 是 |
| name     | 预案题名称  | String | 否 |
| createTime  | 创建时间 | Date | 否 |
| operateTime | 更新时间 | Date | 否 |
| question | 预案问题    | String | 否 |
| author | 作者     | 用户实体类，参数详见[[用户数据服务接口#用户实体类参数说明]] | 否 |
| eventInfo  | 事件 | 事件实体类，参数详见[[事件数据服务接口#事件实体类参数说明]] | 否 |
| subject | 科目 | 科目实体类，参数详见[[科目数据服务接口#科目实体类参数说明]] | 否 |
| course  | 课程 | 课程实体类，参数详见[[课程数据服务接口#课程实体类参数说明]] | 否 |
| map     | 地图 | 地图实体类，参数详见[[地图数据服务接口#地图实体类参数说明]] | 否 |

# 1、获取所有预案题

**请求说明：**

请求路径：http:// **IP** : **PORT** /BFCCT_SERVICE_DATA/planExam?subjectCode= **SUBJECTCODE**&courseCode= **COURSECODE**&courseId= **COURSEID**&param={"page":PAGE,"limit":LIMIT,"order":ORDER}
请求方式：GET

**参数说明：**

| 参数名称 | 说明 | 必备 |
|--------- |:------|:----:|
| IP       | 服务器IP | 是 |
| PORT     | 服务器端口 | 是 |
| SUBJECTCODE | 科目编码 | 否 |
| COURSECODE | 课程编码 | 否 |
| COURSEID   | 课程ID  | 否 |
| ORDER    | 排序字符串，采用“字段名.排序类型”的方式，多列排序采用逗号进行分隔 | 否 |
| PAGE     | 分页号   | 否  |
| LIMIT    | 页容量   | 否  |

* 注：当不需要指定分页相关信息时，可省略请求路径问号后的内容（包含问号）。

**返回参数说明：**

| 参数名称 |    说明     |
|---------|:-----------|
| status  | 状态，success表示成功，error表示失败   |
| message | 消息，显示错误信息   |
| data    | 结果数据 |
| limit   | 页容量   |
| slider  | 分页列表 |
| lastPage | 是否为最后一页 |
| nextPage | 下一页 |
| hasNextPage | 是否有下一页 |
| hasPrePage | 是否有上一页 |
| endRow   | 本分页最后一条记录的序号 |
| prePage  | 上一页 |
| totalCount | 总数 |
| page     | 当前页 |
| items    | 分页结果列表，内容项参数说明参见[[预案题数据服务接口#预案题实体类参数说明]] |
| startRow | 本分页第一条记录的序号 |
| firstPage | 是否为第一页 |
| offset   | 偏移量 |
| totalPages | 总页数 |

**示例：**

* 请求：[http://10.0.0.186:8080/BFCCT_SERVICE_DATA/planExam?param={"order":"name.asc","page":1,"limit":1}]( http://10.0.0.186:8080/BFCCT_SERVICE_DATA/planExam?param={"order":"name.asc","page":1,"limit":1})
* 返回结果：

```javascript
{
  "status": "success",
  "message": "",
  "data": {
    "limit": 1,
    "slider": [
      1,
      2,
      3,
      4,
      5,
      6,
      7
    ],
    "lastPage": false,
    "hasNextPage": true,
    "nextPage": 2,
    "hasPrePage": false,
    "endRow": 1,
    "prePage": 1,
    "totalCount": 14,
    "page": 1,
    "items": [
      {
        "id": "d2bdca9314104daba6de7dc97561f086",
        "name": "毒品交易预案题",
        "eventInfo": {
          "id": "18e243c74da84f33abf95fbf7468d6ef",
          "name": "中缅边境毒品交易事件",
          "type": "毒品事件",
          "time": "2015-03-13 15:30:59",
          "location": "中缅边境",
          "locationLon": 116.89,
          "locationLat": 67.4,
          "suspects": "张三，李四，王五",
          "description": "2015年1月21日，中缅边境发现毒品交易事件。",
          "attachments": null,
          "eventComponents": [
            {
              "field": "OPT_CHARACTER",
              "value": [
                {
                  "id": "1231313",
                  "optionItem": "贩毒",
                  "field": "OPT_CHARACTER",
                  "type": "毒品事件",
                  "description": "性质"
                }
              ],
              "description": "性质"
            },
            {
              "field": "RES_DRUG_TYPE",
              "value": [
                {
                  "resource": {
                    "code": "0300",
                    "name": "海洛因",
                    "model": null,
                    "parentCode": "03",
                    "namePath": "毒品/海洛因",
                    "unitType": "毒品",
                    "type": 1,
                    "isDefault": 0
                  },
                  "count": 500,
                  "unit": {
                    "id": "13fb0f3befdc4c3b9f6480a547adb0ad",
                    "name": "克",
                    "type": "毒品"
                  }
                },
                {
                  "resource": {
                    "code": "0301",
                    "name": "冰毒",
                    "model": null,
                    "parentCode": "03",
                    "namePath": "毒品/冰毒",
                    "unitType": "毒品",
                    "type": 1,
                    "isDefault": 0
                  },
                  "count": 20,
                  "unit": {
                    "id": "754ac7e18f974b95a25c4c8d3c29b79f",
                    "name": "支",
                    "type": "武器"
                  }
                }
              ],
              "description": "毒品类型"
            },
            {
              "field": "NUM_FUNDS",
              "value": 160,
              "description": "毒资，单位（万元）"
            },
            {
              "field": "RES_TRANSPORT",
              "value": [
                {
                  "resource": {
                    "code": "010206",
                    "name": "汽车",
                    "model": null,
                    "parentCode": "0102",
                    "namePath": "装具/设备/汽车",
                    "unitType": "交通工具",
                    "type": 1,
                    "isDefault": 0
                  },
                  "count": 2,
                  "unit": {
                    "id": "f232e1951e054d8e8592b53c01a02f8c",
                    "name": "辆",
                    "type": "交通工具"
                  }
                }
              ],
              "description": "交通工具"
            },
            {
              "field": "RES_WEAPON",
              "value": [
                {
                  "resource": {
                    "code": "010000",
                    "name": "冲锋枪",
                    "model": null,
                    "parentCode": "0100",
                    "namePath": "装具/武器/冲锋枪",
                    "unitType": "武器",
                    "type": 1,
                    "isDefault": 0
                  },
                  "count": 3,
                  "unit": {
                    "id": "754ac7e18f974b95a25c4c8d3c29b79f",
                    "name": "支",
                    "type": "武器"
                  }
                },
                {
                  "resource": {
                    "code": "010001",
                    "name": "手枪",
                    "model": null,
                    "parentCode": "0100",
                    "namePath": "装具/武器/手枪",
                    "unitType": "武器",
                    "type": 1,
                    "isDefault": 0
                  },
                  "count": 5,
                  "unit": {
                    "id": "cac8af5c4b3640c0aa212ad774d9a095",
                    "name": "把",
                    "type": "武器"
                  }
                }
              ],
              "description": "携带武器"
            }
          ]
        },
        "author": {
          "username": "0101001",
          "password": "E10ADC3949BA59ABBE56E057F20F883E",
          "lastIP": "10.0.0.34:2577",
          "loginStatus": 0,
          "role": "教师",
          "student": null,
          "teacher": {
            "id": "e7e4ae6f6c3b4d00b8e2d901fc5618a6",
            "code": "0101001",
            "professionalTitle": {
              "type": "ZCDM",
              "code": "020101",
              "description": "教授",
              "status": "1"
            },
            "personnelInfo": {
              "id": "e0897a074055422d877af537025e6ccb",
              "name": "周浩然",
              "gender": "男",
              "birthday": "1980-10-16",
              "contactInfo": {
                "id": "be590a19f46445a9a1913f8eb4b0b1e0",
                "address": "河北省廊坊市安次区武警学院",
                "phone": "0316-2068331",
                "mobilePhone": "13700375626",
                "email": "zhouhaoran@163.com"
              }
            },
            "collegeOrg": {
              "code": "0101",
              "name": "边防指挥系",
              "parentCode": "01",
              "description": null,
              "type": "1"
            },
            "isTeacher": "1"
          },
          "trainType": "预案生成",
          "trainId": "423b5c7703c4473a998d87ef5772bd97",
          "trainStatus": 0
        },
        "createTime": "2015-03-13 17:28:51",
        "operateTime": "2015-03-13 17:28:51",
        "question": "做出针对该毒品交易的抓捕方案",
        "subject": {
          "code": "010101010101",
          "name": "事件处置",
          "course": {
            "id": "f04fd104b0514b4f93fbb39c463fc07d",
            "code": "0101010101",
            "name": "边防指挥学",
            "description": null
          }
        },
        "course": {
          "id": "f04fd104b0514b4f93fbb39c463fc07d",
          "code": "0101010101",
          "name": "边防指挥学",
          "description": null
        },
        "map": {
          "id": "b630b70542154f5d9c33257269892102",
          "name": "中缅边境",
          "xmin": 88,
          "xmax": 107,
          "ymin": 12,
          "ymax": 30,
          "worldCamera": "PD94bWwgdmVyc2lvbjYW1lcmE+",
          "mapFile2D": "CwImEXi1zUa0IidmKAAAAA=",
          "mapFile3D": "PD94bWwgdmVyc2W1lbnQ+",
          "parentID": "2d38edac5c6f4b78939cc9eff56ac312",
          "type": 1
        }
      }
    ],
    "startRow": 1,
    "firstPage": true,
    "offset": 0,
    "totalPages": 14
  }
}
```

# 2、添加预案题

**请求说明：**

请求路径：http:// **IP** : **PORT** /BFCCT_SERVICE_DATA/planExam
请求方式：POST
请求体参数：预案题对象集合序列化后的json字符串

```javascript
[{"id":ID,"name":NAME,"eventInfo":OBJ_EVENT,"author":OBJ_USER,"createTime":CREATE_TIME,"operateTime":OPERATE_TIME,"question":QUESTION,"subject":OBJ_SUBJECT,"course":OBJ_COURSE,"map":OBJ_MAP}]
```

**参数说明：**

| 参数名称 | 说明 | 必备 |
|---------|:------|:----:|
| IP      | 服务器IP | 是 |
| PORT    | 服务器端口 | 是 |
| 请求体参数 | 参数说明详见[[预案题数据服务接口#预案题实体类参数说明]]   |  |

**返回参数说明：**

| 参数名称 |    说明     |
|---------|:-----------|
| status  | 状态，success表示成功，error表示失败   |
| message | 消息，显示错误信息   |
| data    | 结果数据，若添加成功，则这里存放预案题ID |

**示例：**

* 请求：[http://10.0.0.186:8080/BFCCT_SERVICE_DATA/planExam]( http://10.0.0.186:8080/BFCCT_SERVICE_DATA/planExam)
* 请求体参数：[{"id":null,"name":"毒品交易预案题","eventInfo":{"id":"18e243c74da84f33abf95fbf7468d6ef","name":"中缅边境毒品交易事件","type":"毒品事件","time":"2015-03-13 15:30:59","location":"中缅边境","locationLon":116.89,"locationLat":67.4,"suspects":"张三，李四，王五","description":"2015年1月21日，中缅边境发现毒品交易事件。","attachments":null,"eventComponents":[{"field":"OPT_CHARACTER","value":[{"id":"1231313","optionItem":"贩毒","field":"OPT_CHARACTER","type":"毒品事件","description":"性质"}],"description":"性质"},{"field":"RES_DRUG_TYPE","value":[{"resource":{"code":"0300","name":"海洛因","model":null,"parentCode":"03","namePath":"毒品/海洛因","unitType":"毒品","type":1,"isDefault":0},"count":500,"unit":{"id":"13fb0f3befdc4c3b9f6480a547adb0ad","name":"克","type":"毒品"}},{"resource":{"code":"0301","name":"冰毒","model":null,"parentCode":"03","namePath":"毒品/冰毒","unitType":"毒品","type":1,"isDefault":0},"count":20,"unit":{"id":"754ac7e18f974b95a25c4c8d3c29b79f","name":"支","type":"武器"}}],"description":"毒品类型"},{"field":"NUM_FUNDS","value":160,"description":"毒资，单位（万元）"},{"field":"RES_TRANSPORT","value":[{"resource":{"code":"010206","name":"汽车","model":null,"parentCode":"0102","namePath":"装具/设备/汽车","unitType":"交通工具","type":1,"isDefault":0},"count":2,"unit":{"id":"f232e1951e054d8e8592b53c01a02f8c","name":"辆","type":"交通工具"}}],"description":"交通工具"},{"field":"RES_WEAPON","value":[{"resource":{"code":"010000","name":"冲锋枪","model":null,"parentCode":"0100","namePath":"装具/武器/冲锋枪","unitType":"武器","type":1,"isDefault":0},"count":3,"unit":{"id":"754ac7e18f974b95a25c4c8d3c29b79f","name":"支","type":"武器"}},{"resource":{"code":"010001","name":"手枪","model":null,"parentCode":"0100","namePath":"装具/武器/手枪","unitType":"武器","type":1,"isDefault":0},"count":5,"unit":{"id":"cac8af5c4b3640c0aa212ad774d9a095","name":"把","type":"武器"}}],"description":"携带武器"}]},"author":{"username":"0101001","password":"E10ADC3949BA59ABBE56E057F20F883E","lastIP":"10.0.0.34:2577","loginStatus":0,"role":"教师","student":null,"teacher":{"id":"e7e4ae6f6c3b4d00b8e2d901fc5618a6","code":"0101001","professionalTitle":{"type":"ZCDM","code":"020101","description":"教授","status":"1"},"personnelInfo":{"id":"e0897a074055422d877af537025e6ccb","name":"周浩然","gender":"男","birthday":"1980-10-16","contactInfo":{"id":"be590a19f46445a9a1913f8eb4b0b1e0","address":"河北省廊坊市安次区武警学院","phone":"0316-2068331","mobilePhone":"13700375626","email":"zhouhaoran@163.com"}},"collegeOrg":{"code":"0101","name":"边防指挥系","parentCode":"01","description":null,"type":"1"},"isTeacher":"1"},"trainType":"预案生成","trainId":"423b5c7703c4473a998d87ef5772bd97","trainStatus":0},"createTime":null,"operateTime":null,"question":"做出针对该毒品交易的抓捕方案","subject":{"code":"010101010101","name":"事件处置","course":{"id":"f04fd104b0514b4f93fbb39c463fc07d","code":"0101010101","name":"边防指挥学","description":null}},"course":{"id":"f04fd104b0514b4f93fbb39c463fc07d","code":"0101010101","name":"边防指挥学","description":null},"map":{"id":"b630b70542154f5d9c33257269892102","name":"中缅边境","xmin":88,"xmax":107,"ymin":12,"ymax":30,"worldCamera":"PD94bWwgdmYW1lcmE+","mapFile2D":"CwImEXiAAAAAA=","mapFile3D":"PD94bWwgdW1lbnQ+","parentID":"2d38edac5c6f4b78939cc9eff56ac312","type":1}}]
* 返回结果：

```javascript
{
    "status": "success",
    "message": "",
    "data": [
        "d2bdca9314104daba6de7dc97561f086"
    ]
}
```

# 3、删除预案题

**请求说明：**

请求路径：http:// **IP** : **PORT** /BFCCT_SERVICE_DATA/planExam
请求方式：DELETE
请求体参数：预案题对象集合序列化后的json字符串

```javascript
[{"id":ID}]
```

**参数说明：**

| 参数名称 | 说明 | 必备 |
|---------|:------|:----:|
| IP      | 服务器IP | 是 |
| PORT    | 服务器端口 | 是 |
| ID      | 预案题ID    | 是 |

**返回参数说明：**

| 参数名称 |    说明     |
|---------|:-----------|
| status  | 状态，success表示成功，error表示失败   |
| message | 消息，显示错误信息   |
| data    | 结果数据 |

**示例：**

* 请求：[http://10.0.0.186:8080/BFCCT_SERVICE_DATA/planExam]( http://10.0.0.186:8080/BFCCT_SERVICE_DATA/planExam)
* 请求体参数：[{"id":"d2bdca9314104daba6de7dc97561f086"}]
* 返回结果：

```javascript
{
    "status": "success",
    "message": "",
    "data": null
}
```

# 4、更新预案题

**请求说明：**

请求路径：http:// **IP** : **PORT** /BFCCT_SERVICE_DATA/planExam
请求方式：PUT
请求体参数：预案题对象集合序列化后的json字符串

```javascript
[{"id":ID,"name":NAME,"eventInfo":OBJ_EVENT,"author":OBJ_USER,"createTime":CREATE_TIME,"operateTime":OPERATE_TIME,"question":QUESTION,"subject":OBJ_SUBJECT,"course":OBJ_COURSE,"map":OBJ_MAP}]
```

**参数说明：**

| 参数名称 | 说明 | 必备 |
|---------|:------|:----:|
| IP      | 服务器IP | 是 |
| PORT    | 服务器端口 | 是 |
| 请求体参数 | 参数说明详见[[预案题数据服务接口#预案题实体类参数说明]]   |  |

**返回参数说明：**

| 参数名称 |    说明     |
|---------|:-----------|
| status  | 状态，success表示成功，error表示失败   |
| message | 消息，显示错误信息   |
| data    | 结果数据 |

**示例：**

* 请求：[http://10.0.0.186:8080/BFCCT_SERVICE_DATA/planExam]( http://10.0.0.186:8080/BFCCT_SERVICE_DATA/planExam)
* 请求体参数：[{"id":"d2bdca9314104daba6de7dc97561f086","name":"毒品交易预案题2","eventInfo":{"id":"18e243c74da84f33abf95fbf7468d6ef","name":"中缅边境毒品交易事件","type":"毒品事件","time":"2015-03-13 15:30:59","location":"中缅边境","locationLon":116.89,"locationLat":67.4,"suspects":"张三，李四，王五","description":"2015年1月21日，中缅边境发现毒品交易事件。","attachments":null,"eventComponents":[{"field":"OPT_CHARACTER","value":[{"id":"1231313","optionItem":"贩毒","field":"OPT_CHARACTER","type":"毒品事件","description":"性质"}],"description":"性质"},{"field":"RES_DRUG_TYPE","value":[{"resource":{"code":"0300","name":"海洛因","model":null,"parentCode":"03","namePath":"毒品/海洛因","unitType":"毒品","type":1,"isDefault":0},"count":500,"unit":{"id":"13fb0f3befdc4c3b9f6480a547adb0ad","name":"克","type":"毒品"}},{"resource":{"code":"0301","name":"冰毒","model":null,"parentCode":"03","namePath":"毒品/冰毒","unitType":"毒品","type":1,"isDefault":0},"count":20,"unit":{"id":"754ac7e18f974b95a25c4c8d3c29b79f","name":"支","type":"武器"}}],"description":"毒品类型"},{"field":"NUM_FUNDS","value":160,"description":"毒资，单位（万元）"},{"field":"RES_TRANSPORT","value":[{"resource":{"code":"010206","name":"汽车","model":null,"parentCode":"0102","namePath":"装具/设备/汽车","unitType":"交通工具","type":1,"isDefault":0},"count":2,"unit":{"id":"f232e1951e054d8e8592b53c01a02f8c","name":"辆","type":"交通工具"}}],"description":"交通工具"},{"field":"RES_WEAPON","value":[{"resource":{"code":"010000","name":"冲锋枪","model":null,"parentCode":"0100","namePath":"装具/武器/冲锋枪","unitType":"武器","type":1,"isDefault":0},"count":3,"unit":{"id":"754ac7e18f974b95a25c4c8d3c29b79f","name":"支","type":"武器"}},{"resource":{"code":"010001","name":"手枪","model":null,"parentCode":"0100","namePath":"装具/武器/手枪","unitType":"武器","type":1,"isDefault":0},"count":5,"unit":{"id":"cac8af5c4b3640c0aa212ad774d9a095","name":"把","type":"武器"}}],"description":"携带武器"}]},"author":{"username":"0101001","password":"E10ADC3949BA59ABBE56E057F20F883E","lastIP":"10.0.0.34:2577","loginStatus":0,"role":"教师","student":null,"teacher":{"id":"e7e4ae6f6c3b4d00b8e2d901fc5618a6","code":"0101001","professionalTitle":{"type":"ZCDM","code":"020101","description":"教授","status":"1"},"personnelInfo":{"id":"e0897a074055422d877af537025e6ccb","name":"周浩然","gender":"男","birthday":"1980-10-16","contactInfo":{"id":"be590a19f46445a9a1913f8eb4b0b1e0","address":"河北省廊坊市安次区武警学院","phone":"0316-2068331","mobilePhone":"13700375626","email":"zhouhaoran@163.com"}},"collegeOrg":{"code":"0101","name":"边防指挥系","parentCode":"01","description":null,"type":"1"},"isTeacher":"1"},"trainType":"预案生成","trainId":"423b5c7703c4473a998d87ef5772bd97","trainStatus":0},"createTime":null,"operateTime":null,"question":"做出针对该毒品交易的抓捕方案","subject":{"code":"010101010101","name":"事件处置","course":{"id":"f04fd104b0514b4f93fbb39c463fc07d","code":"0101010101","name":"边防指挥学","description":null}},"course":{"id":"f04fd104b0514b4f93fbb39c463fc07d","code":"0101010101","name":"边防指挥学","description":null},"map":{"id":"b630b70542154f5d9c33257269892102","name":"中缅边境","xmin":88,"xmax":107,"ymin":12,"ymax":30,"worldCamera":"PD94bWwgdmYW1lcmE+","mapFile2D":"CwImEXiAAAAAA=","mapFile3D":"PD94bWwgdW1lbnQ+","parentID":"2d38edac5c6f4b78939cc9eff56ac312","type":1}}]
* 返回结果：

```javascript
{
    "status": "success",
    "message": "",
    "data": null
}
```

# 5、通过ID获取预案题信息

**请求说明：**

请求路径：http:// **IP** : **PORT** /BFCCT_SERVICE_DATA/planExam/ **ID**
请求方式：GET

**参数说明：**

| 参数名称 | 说明 | 必备 |
|--------- |:------|:----:|
| IP       | 服务器IP | 是 |
| PORT     | 服务器端口 | 是 |
| ID       | 预案题ID    | 是 |

**返回参数说明：**

| 参数名称 |    说明     |
|---------|:-----------|
| status  | 状态，success表示成功，error表示失败   |
| message | 消息，显示错误信息   |
| data    | 结果数据，内容项参数说明参见[[预案题数据服务接口#预案题实体类参数说明]] |

**示例：**

* 请求：[http://10.0.0.186:8080/BFCCT_SERVICE_DATA/planExam/d2bdca9314104daba6de7dc97561f086]( http://10.0.0.186:8080/BFCCT_SERVICE_DATA/planExam/d2bdca9314104daba6de7dc97561f086)
* 返回结果：

```javascript
{
  "status": "success",
  "message": "",
  "data": {
    "id": "d2bdca9314104daba6de7dc97561f086",
    "name": "毒品交易预案题",
    "eventInfo": {
      "id": "18e243c74da84f33abf95fbf7468d6ef",
      "name": "中缅边境毒品交易事件",
      "type": "毒品事件",
      "time": "2015-03-13 15:30:59",
      "location": "中缅边境",
      "locationLon": 116.89,
      "locationLat": 67.4,
      "suspects": "张三，李四，王五",
      "description": "2015年1月21日，中缅边境发现毒品交易事件。",
      "attachments": null,
      "eventComponents": [
        {
          "field": "OPT_CHARACTER",
          "value": [
            {
              "id": "1231313",
              "optionItem": "贩毒",
              "field": "OPT_CHARACTER",
              "type": "毒品事件",
              "description": "性质"
            }
          ],
          "description": "性质"
        },
        {
          "field": "RES_DRUG_TYPE",
          "value": [
            {
              "resource": {
                "code": "0300",
                "name": "海洛因",
                "model": null,
                "parentCode": "03",
                "namePath": "毒品/海洛因",
                "unitType": "毒品",
                "type": 1,
                "isDefault": 0
              },
              "count": 500,
              "unit": {
                "id": "13fb0f3befdc4c3b9f6480a547adb0ad",
                "name": "克",
                "type": "毒品"
              }
            },
            {
              "resource": {
                "code": "0301",
                "name": "冰毒",
                "model": null,
                "parentCode": "03",
                "namePath": "毒品/冰毒",
                "unitType": "毒品",
                "type": 1,
                "isDefault": 0
              },
              "count": 20,
              "unit": {
                "id": "754ac7e18f974b95a25c4c8d3c29b79f",
                "name": "支",
                "type": "武器"
              }
            }
          ],
          "description": "毒品类型"
        },
        {
          "field": "NUM_FUNDS",
          "value": 160,
          "description": "毒资，单位（万元）"
        },
        {
          "field": "RES_TRANSPORT",
          "value": [
            {
              "resource": {
                "code": "010206",
                "name": "汽车",
                "model": null,
                "parentCode": "0102",
                "namePath": "装具/设备/汽车",
                "unitType": "交通工具",
                "type": 1,
                "isDefault": 0
              },
              "count": 2,
              "unit": {
                "id": "f232e1951e054d8e8592b53c01a02f8c",
                "name": "辆",
                "type": "交通工具"
              }
            }
          ],
          "description": "交通工具"
        },
        {
          "field": "RES_WEAPON",
          "value": [
            {
              "resource": {
                "code": "010000",
                "name": "冲锋枪",
                "model": null,
                "parentCode": "0100",
                "namePath": "装具/武器/冲锋枪",
                "unitType": "武器",
                "type": 1,
                "isDefault": 0
              },
              "count": 3,
              "unit": {
                "id": "754ac7e18f974b95a25c4c8d3c29b79f",
                "name": "支",
                "type": "武器"
              }
            },
            {
              "resource": {
                "code": "010001",
                "name": "手枪",
                "model": null,
                "parentCode": "0100",
                "namePath": "装具/武器/手枪",
                "unitType": "武器",
                "type": 1,
                "isDefault": 0
              },
              "count": 5,
              "unit": {
                "id": "cac8af5c4b3640c0aa212ad774d9a095",
                "name": "把",
                "type": "武器"
              }
            }
          ],
          "description": "携带武器"
        }
      ]
    },
    "author": {
      "username": "0101001",
      "password": "E10ADC3949BA59ABBE56E057F20F883E",
      "lastIP": "10.0.0.34:2577",
      "loginStatus": 0,
      "role": "教师",
      "student": null,
      "teacher": {
        "id": "e7e4ae6f6c3b4d00b8e2d901fc5618a6",
        "code": "0101001",
        "professionalTitle": {
          "type": "ZCDM",
          "code": "020101",
          "description": "教授",
          "status": "1"
        },
        "personnelInfo": {
          "id": "e0897a074055422d877af537025e6ccb",
          "name": "周浩然",
          "gender": "男",
          "birthday": "1980-10-16",
          "contactInfo": {
            "id": "be590a19f46445a9a1913f8eb4b0b1e0",
            "address": "河北省廊坊市安次区武警学院",
            "phone": "0316-2068331",
            "mobilePhone": "13700375626",
            "email": "zhouhaoran@163.com"
          }
        },
        "collegeOrg": {
          "code": "0101",
          "name": "边防指挥系",
          "parentCode": "01",
          "description": "专业名称：边防指挥 专业代码：680202 专业核心能力：具有部队管理与指挥的能力。",
          "type": "1"
        },
        "isTeacher": "1"
      },
      "trainType": "预案生成",
      "trainId": "423b5c7703c4473a998d87ef5772bd97",
      "trainStatus": 0
    },
    "createTime": "2015-03-13 17:28:51",
    "operateTime": "2015-03-13 17:28:51",
    "question": "做出针对该毒品交易的抓捕方案",
    "subject": {
      "code": "010101010101",
      "name": "事件处置",
      "course": {
        "id": "f04fd104b0514b4f93fbb39c463fc07d",
        "code": "0101010101",
        "name": "边防指挥学",
        "description": null
      }
    },
    "course": {
      "id": "f04fd104b0514b4f93fbb39c463fc07d",
      "code": "0101010101",
      "name": "边防指挥学",
      "description": null
    },
    "map": {
      "id": "b630b70542154f5d9c33257269892102",
      "name": "中缅边境",
      "xmin": 88,
      "xmax": 107,
      "ymin": 12,
      "ymax": 30,
      "worldCamera": "PD94bWwgdmVW1lcmE+",
      "mapFile2D": "CwImEXi1zUa0IAAA=",
      "mapFile3D": "PD94bWwgdmVybnQ+",
      "parentID": "2d38edac5c6f4b78939cc9eff56ac312",
      "type": 1
    }
  }
}
```

# 6、多条件查询预案题

**请求说明：**

请求路径：http:// **IP** : **PORT** /BFCCT_SERVICE_DATA/planExam/query?param={"page":PAGE,"limit":LIMIT,"order":ORDER,"andFields":[{"field":FIELD,"value":VALUE,"type":TYPE}],"orFields":[{"field":FIELD,"value":VALUE,"type":TYPE}]}

请求方式：GET

**参数说明：**

| 参数名称 | 说明 | 必备 |
|--------- |:------|:----:|
| IP       | 服务器IP | 是 |
| PORT     | 服务器端口 | 是 |
| FIELD    | 字段名 | 是  |
| VALUE    | 字段值   | 是  |
| TYPE     | 查询类型，LIKE表示模糊查询，EQUAL表示精确查询 | 是 |
| ORDER    | 排序字符串，采用“字段名.排序类型”的方式，多列排序采用逗号进行分隔 | 否 |
| PAGE     | 分页号   | 否  |
| LIMIT    | 页容量   | 否  |

* 注：andFields是逻辑且查询条件，orFields是逻辑或查询条件，两者之间是逻辑且关系。

**返回参数说明：**

| 参数名称 |    说明     |
|---------|:-----------|
| status  | 状态，success表示成功，error表示失败   |
| message | 消息，显示错误信息   |
| data    | 结果数据 |
| limit   | 页容量   |
| slider  | 分页列表 |
| lastPage | 是否为最后一页 |
| nextPage | 下一页 |
| hasNextPage | 是否有下一页 |
| hasPrePage | 是否有上一页 |
| endRow   | 本分页最后一条记录的序号 |
| prePage  | 上一页 |
| totalCount | 总数 |
| page     | 当前页 |
| items    | 分页结果列表，内容项参数说明参见[[预案题数据服务接口#预案题实体类参数说明]] |
| startRow | 本分页第一条记录的序号 |
| firstPage | 是否为第一页 |
| offset   | 偏移量 |
| totalPages | 总页数 |

**示例：**

* 请求：[http://10.0.0.186:8080/BFCCT_SERVICE_DATA/planExam/query?param={"order":"name.asc","page":1,"limit":1,"andFields":[{"field":"name","value":"预案题","type":"LIKE"}],"orFields":null}]( http://10.0.0.186:8080/BFCCT_SERVICE_DATA/planExam/query?param={"order":"name.asc","page":1,"limit":1,"andFields":[{"field":"name","value":"预案题","type":"LIKE"}],"orFields":null})
* 返回结果：

```javascript
{
  "status": "success",
  "message": "",
  "data": {
    "limit": 1,
    "slider": [
      1,
      2,
      3,
      4
    ],
    "lastPage": false,
    "hasNextPage": true,
    "nextPage": 2,
    "hasPrePage": false,
    "endRow": 1,
    "prePage": 1,
    "totalCount": 4,
    "page": 1,
    "items": [
      {
        "id": "d2bdca9314104daba6de7dc97561f086",
        "name": "毒品交易预案题",
        "eventInfo": {
          "id": "18e243c74da84f33abf95fbf7468d6ef",
          "name": "中缅边境毒品交易事件",
          "type": "毒品事件",
          "time": "2015-03-13 15:30:59",
          "location": "中缅边境",
          "locationLon": 116.89,
          "locationLat": 67.4,
          "suspects": "张三，李四，王五",
          "description": "2015年1月21日，中缅边境发现毒品交易事件。",
          "attachments": null,
          "eventComponents": [
            {
              "field": "OPT_CHARACTER",
              "value": [
                {
                  "id": "1231313",
                  "optionItem": "贩毒",
                  "field": "OPT_CHARACTER",
                  "type": "毒品事件",
                  "description": "性质"
                }
              ],
              "description": "性质"
            },
            {
              "field": "RES_DRUG_TYPE",
              "value": [
                {
                  "resource": {
                    "code": "0300",
                    "name": "海洛因",
                    "model": null,
                    "parentCode": "03",
                    "namePath": "毒品/海洛因",
                    "unitType": "毒品",
                    "type": 1,
                    "isDefault": 0
                  },
                  "count": 500,
                  "unit": {
                    "id": "13fb0f3befdc4c3b9f6480a547adb0ad",
                    "name": "克",
                    "type": "毒品"
                  }
                },
                {
                  "resource": {
                    "code": "0301",
                    "name": "冰毒",
                    "model": null,
                    "parentCode": "03",
                    "namePath": "毒品/冰毒",
                    "unitType": "毒品",
                    "type": 1,
                    "isDefault": 0
                  },
                  "count": 20,
                  "unit": {
                    "id": "754ac7e18f974b95a25c4c8d3c29b79f",
                    "name": "支",
                    "type": "武器"
                  }
                }
              ],
              "description": "毒品类型"
            },
            {
              "field": "NUM_FUNDS",
              "value": 160,
              "description": "毒资，单位（万元）"
            },
            {
              "field": "RES_TRANSPORT",
              "value": [
                {
                  "resource": {
                    "code": "010206",
                    "name": "汽车",
                    "model": null,
                    "parentCode": "0102",
                    "namePath": "装具/设备/汽车",
                    "unitType": "交通工具",
                    "type": 1,
                    "isDefault": 0
                  },
                  "count": 2,
                  "unit": {
                    "id": "f232e1951e054d8e8592b53c01a02f8c",
                    "name": "辆",
                    "type": "交通工具"
                  }
                }
              ],
              "description": "交通工具"
            },
            {
              "field": "RES_WEAPON",
              "value": [
                {
                  "resource": {
                    "code": "010000",
                    "name": "冲锋枪",
                    "model": null,
                    "parentCode": "0100",
                    "namePath": "装具/武器/冲锋枪",
                    "unitType": "武器",
                    "type": 1,
                    "isDefault": 0
                  },
                  "count": 3,
                  "unit": {
                    "id": "754ac7e18f974b95a25c4c8d3c29b79f",
                    "name": "支",
                    "type": "武器"
                  }
                },
                {
                  "resource": {
                    "code": "010001",
                    "name": "手枪",
                    "model": null,
                    "parentCode": "0100",
                    "namePath": "装具/武器/手枪",
                    "unitType": "武器",
                    "type": 1,
                    "isDefault": 0
                  },
                  "count": 5,
                  "unit": {
                    "id": "cac8af5c4b3640c0aa212ad774d9a095",
                    "name": "把",
                    "type": "武器"
                  }
                }
              ],
              "description": "携带武器"
            }
          ]
        },
        "author": {
          "username": "0101001",
          "password": "E10ADC3949BA59ABBE56E057F20F883E",
          "lastIP": "10.0.0.34:2577",
          "loginStatus": 0,
          "role": "教师",
          "student": null,
          "teacher": {
            "id": "e7e4ae6f6c3b4d00b8e2d901fc5618a6",
            "code": "0101001",
            "professionalTitle": {
              "type": "ZCDM",
              "code": "020101",
              "description": "教授",
              "status": "1"
            },
            "personnelInfo": {
              "id": "e0897a074055422d877af537025e6ccb",
              "name": "周浩然",
              "gender": "男",
              "birthday": "1980-10-16",
              "contactInfo": {
                "id": "be590a19f46445a9a1913f8eb4b0b1e0",
                "address": "河北省廊坊市安次区武警学院",
                "phone": "0316-2068331",
                "mobilePhone": "13700375626",
                "email": "zhouhaoran@163.com"
              }
            },
            "collegeOrg": {
              "code": "0101",
              "name": "边防指挥系",
              "parentCode": "01",
              "description": "专业名称：边防指挥 专业代码：680202 专业核心能力：具有部队管理与指挥的能力。",
              "type": "1"
            },
            "isTeacher": "1"
          },
          "trainType": "预案生成",
          "trainId": "423b5c7703c4473a998d87ef5772bd97",
          "trainStatus": 0
        },
        "createTime": "2015-03-13 17:28:51",
        "operateTime": "2015-03-13 17:28:51",
        "question": "做出针对该毒品交易的抓捕方案",
        "subject": {
          "code": "010101010101",
          "name": "事件处置",
          "course": {
            "id": "f04fd104b0514b4f93fbb39c463fc07d",
            "code": "0101010101",
            "name": "边防指挥学",
            "description": null
          }
        },
        "course": {
          "id": "f04fd104b0514b4f93fbb39c463fc07d",
          "code": "0101010101",
          "name": "边防指挥学",
          "description": null
        },
        "map": {
          "id": "b630b70542154f5d9c33257269892102",
          "name": "中缅边境",
          "xmin": 88,
          "xmax": 107,
          "ymin": 12,
          "ymax": 30,
          "worldCamera": "PD94bWwgdmVyc2lvbPC9DYW1lcmE+",
          "mapFile2D": "CwImEXi1zUa0IidmK1AAAAA=",
          "mapFile3D": "PD94bWwgdmVyc2lvbW1lbnQ+",
          "parentID": "2d38edac5c6f4b78939cc9eff56ac312",
          "type": 1
        }
      }
    ],
    "startRow": 1,
    "firstPage": true,
    "offset": 0,
    "totalPages": 4
  }
}
```

# 7、通过作者用户名获取预案题

**请求说明：**

请求路径：http:// **IP** : **PORT** /BFCCT_SERVICE_DATA/planExam?author= **AUTHOR**&param={"page":PAGE,"limit":LIMIT,"order":ORDER}
请求方式：GET

**参数说明：**

| 参数名称 | 说明 | 必备 |
|--------- |:------|:----:|
| IP       | 服务器IP | 是 |
| PORT     | 服务器端口 | 是 |
| AUTHOR   | 作者ID    | 是 |
| ORDER    | 排序字符串，采用“字段名.排序类型”的方式，多列排序采用逗号进行分隔 | 否 |
| PAGE     | 分页号   | 否  |
| LIMIT    | 页容量   | 否  |

* 注：当不需要指定分页相关信息时，可省略请求路径问号后的内容（包含&）。

**返回参数说明：**

| 参数名称 |    说明     |
|---------|:-----------|
| status  | 状态，success表示成功，error表示失败   |
| message | 消息，显示错误信息   |
| data    | 结果数据 |
| limit   | 页容量   |
| slider  | 分页列表 |
| lastPage | 是否为最后一页 |
| nextPage | 下一页 |
| hasNextPage | 是否有下一页 |
| hasPrePage | 是否有上一页 |
| endRow   | 本分页最后一条记录的序号 |
| prePage  | 上一页 |
| totalCount | 总数 |
| page     | 当前页 |
| items    | 分页结果列表，内容项参数说明参见[[预案题数据服务接口#预案题实体类参数说明]] |
| startRow | 本分页第一条记录的序号 |
| firstPage | 是否为第一页 |
| offset   | 偏移量 |
| totalPages | 总页数 |

**示例：**

* 请求：[http://10.0.0.186:8080/BFCCT_SERVICE_DATA/planExam/author/0101001?param={"order":"name.asc","page":1,"limit":1}]( http://10.0.0.186:8080/BFCCT_SERVICE_DATA/planExam/author/0101001?param={"order":"name.asc","page":1,"limit":1})
* 返回结果：

```javascript
{
  "status": "success",
  "message": "",
  "data": {
    "limit": 1,
    "slider": [
      1,
      2,
      3
    ],
    "lastPage": false,
    "hasNextPage": true,
    "nextPage": 2,
    "hasPrePage": false,
    "endRow": 1,
    "prePage": 1,
    "totalCount": 3,
    "page": 1,
    "items": [
      {
        "id": "d2bdca9314104daba6de7dc97561f086",
        "name": "毒品交易预案题",
        "eventInfo": {
          "id": "18e243c74da84f33abf95fbf7468d6ef",
          "name": "中缅边境毒品交易事件",
          "type": "毒品事件",
          "time": "2015-03-13 15:30:59",
          "location": "中缅边境",
          "locationLon": 116.89,
          "locationLat": 67.4,
          "suspects": "张三，李四，王五",
          "description": "2015年1月21日，中缅边境发现毒品交易事件。",
          "attachments": null,
          "eventComponents": [
            {
              "field": "OPT_CHARACTER",
              "value": [
                {
                  "id": "1231313",
                  "optionItem": "贩毒",
                  "field": "OPT_CHARACTER",
                  "type": "毒品事件",
                  "description": "性质"
                }
              ],
              "description": "性质"
            },
            {
              "field": "RES_DRUG_TYPE",
              "value": [
                {
                  "resource": {
                    "code": "0300",
                    "name": "海洛因",
                    "model": null,
                    "parentCode": "03",
                    "namePath": "毒品/海洛因",
                    "unitType": "毒品",
                    "type": 1,
                    "isDefault": 0
                  },
                  "count": 500,
                  "unit": {
                    "id": "13fb0f3befdc4c3b9f6480a547adb0ad",
                    "name": "克",
                    "type": "毒品"
                  }
                },
                {
                  "resource": {
                    "code": "0301",
                    "name": "冰毒",
                    "model": null,
                    "parentCode": "03",
                    "namePath": "毒品/冰毒",
                    "unitType": "毒品",
                    "type": 1,
                    "isDefault": 0
                  },
                  "count": 20,
                  "unit": {
                    "id": "754ac7e18f974b95a25c4c8d3c29b79f",
                    "name": "支",
                    "type": "武器"
                  }
                }
              ],
              "description": "毒品类型"
            },
            {
              "field": "NUM_FUNDS",
              "value": 160,
              "description": "毒资，单位（万元）"
            },
            {
              "field": "RES_TRANSPORT",
              "value": [
                {
                  "resource": {
                    "code": "010206",
                    "name": "汽车",
                    "model": null,
                    "parentCode": "0102",
                    "namePath": "装具/设备/汽车",
                    "unitType": "交通工具",
                    "type": 1,
                    "isDefault": 0
                  },
                  "count": 2,
                  "unit": {
                    "id": "f232e1951e054d8e8592b53c01a02f8c",
                    "name": "辆",
                    "type": "交通工具"
                  }
                }
              ],
              "description": "交通工具"
            },
            {
              "field": "RES_WEAPON",
              "value": [
                {
                  "resource": {
                    "code": "010000",
                    "name": "冲锋枪",
                    "model": null,
                    "parentCode": "0100",
                    "namePath": "装具/武器/冲锋枪",
                    "unitType": "武器",
                    "type": 1,
                    "isDefault": 0
                  },
                  "count": 3,
                  "unit": {
                    "id": "754ac7e18f974b95a25c4c8d3c29b79f",
                    "name": "支",
                    "type": "武器"
                  }
                },
                {
                  "resource": {
                    "code": "010001",
                    "name": "手枪",
                    "model": null,
                    "parentCode": "0100",
                    "namePath": "装具/武器/手枪",
                    "unitType": "武器",
                    "type": 1,
                    "isDefault": 0
                  },
                  "count": 5,
                  "unit": {
                    "id": "cac8af5c4b3640c0aa212ad774d9a095",
                    "name": "把",
                    "type": "武器"
                  }
                }
              ],
              "description": "携带武器"
            }
          ]
        },
        "author": {
          "username": "0101001",
          "password": "E10ADC3949BA59ABBE56E057F20F883E",
          "lastIP": "10.0.0.34:2577",
          "loginStatus": 0,
          "role": "教师",
          "student": null,
          "teacher": {
            "id": "e7e4ae6f6c3b4d00b8e2d901fc5618a6",
            "code": "0101001",
            "professionalTitle": {
              "type": "ZCDM",
              "code": "020101",
              "description": "教授",
              "status": "1"
            },
            "personnelInfo": {
              "id": "e0897a074055422d877af537025e6ccb",
              "name": "周浩然",
              "gender": "男",
              "birthday": "1980-10-16",
              "contactInfo": {
                "id": "be590a19f46445a9a1913f8eb4b0b1e0",
                "address": "河北省廊坊市安次区武警学院",
                "phone": "0316-2068331",
                "mobilePhone": "13700375626",
                "email": "zhouhaoran@163.com"
              }
            },
            "collegeOrg": {
              "code": "0101",
              "name": "边防指挥系",
              "parentCode": "01",
              "description": "专业名称：边防指挥 专业代码：680202 专业核心能力：具有部队管理与指挥的能力。",
              "type": "1"
            },
            "isTeacher": "1"
          },
          "trainType": "预案生成",
          "trainId": "423b5c7703c4473a998d87ef5772bd97",
          "trainStatus": 0
        },
        "createTime": "2015-03-13 17:28:51",
        "operateTime": "2015-03-13 17:28:51",
        "question": "做出针对该毒品交易的抓捕方案",
        "subject": {
          "code": "010101010101",
          "name": "事件处置",
          "course": {
            "id": "f04fd104b0514b4f93fbb39c463fc07d",
            "code": "0101010101",
            "name": "边防指挥学",
            "description": null
          }
        },
        "course": {
          "id": "f04fd104b0514b4f93fbb39c463fc07d",
          "code": "0101010101",
          "name": "边防指挥学",
          "description": null
        },
        "map": {
          "id": "b630b70542154f5d9c33257269892102",
          "name": "中缅边境",
          "xmin": 88,
          "xmax": 107,
          "ymin": 12,
          "ymax": 30,
          "worldCamera": "PD94bWwgdmVyc2lv9DYW1lcmE+",
          "mapFile2D": "CwImEXi1zUa0IidmK1HAAAAA=",
          "mapFile3D": "PD94bWwgdmVyc2lvbW1lbnQ+",
          "parentID": "2d38edac5c6f4b78939cc9eff56ac312",
          "type": 1
        }
      }
    ],
    "startRow": 1,
    "firstPage": true,
    "offset": 0,
    "totalPages": 3
  }
}
```
