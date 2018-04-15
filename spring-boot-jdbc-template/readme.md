
#postman测试
localhost:8080/account/1
* headers:
`Content-Type:application/x-www-form-urlencoded`
* body:
`application/x-www-form-urlencoded`
* Key-Value edit
````
name:tom
money:5000
````

#Issues
1. @RequestParam 获取参数 HTTP Status 400 - Required String parameter 'xx' is not present

application/x-www-form-urlencoded请求是表单请求，可以用@RequestParam一个一个获取参数，当Content-Type == application/json 前端传来的是json串，
用@RequesParam是获取不到的，需要用@RequestBody将json串转为对象