<#import "parts/common.ftl" as c>

<@c.page>
  Add new user
${message}
  <form action="/registration" method="post">
    <div><label> User Name : <input type="text" name="login"/> </label></div>
    <div><label> Password: <input type="password" name="password"/> </label></div>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <div><input type="submit" value="register"/></div>
  </form>

</@c.page>
