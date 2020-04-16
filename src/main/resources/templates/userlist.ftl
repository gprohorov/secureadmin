
<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
</head>
<body>

<h3>Student list</h3>
<br>
<div>

    <table border="3" bgcolor="#f0f8ff">
        <tr>
            <th>Role</th>
            <th>Username</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <#list items as item>
            <tr>
               <#-- <td>${item.authorities }</td>-->

                <td>${item.authorities}</td>
                <td>${item.username}</td>
                <td><a href="#" type="button">Edit</a> </td>
                <td><a href="#" type="button">Delete</a> </td>



            </tr>
        </#list>
    </table>

</div>

<a href="/student/add">Add new student</a>


</body>
</html>
