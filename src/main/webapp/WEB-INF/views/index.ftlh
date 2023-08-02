<!DOCTYPE html>
<html>
<head>
    <title>Hello FreeMarker</title>
</head>
<body>
<h1>${message}</h1>

<ul>
    <#list menu as menuItem>
        <li><a href="${menuItem.link}">${menuItem.label}</a></li>
    </#list>
</ul>

</body>
</html>