<!DOCTYPE html>
<html>
<head>
    <title>Student Form</title>
</head>
<body>

<ul>
    <#list menu as menuItem>
        <li><a href="${menuItem.link}">${menuItem.label}</a></li>
    </#list>
</ul>

<h1>Add Student</h1>
<form id="studentForm" onsubmit="submitForm(); return false;">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name"><br>
    <label for="email">Email:</label>
    <input type="email" id="email" name="email"><br>
    <button type="submit">Submit</button>
</form>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    function submitForm() {
        var formData = {
            "name": $("#name").val(),
            "email": $("#email").val()
        };

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/badex_war_exploded/categories",
            data: JSON.stringify(formData),
            dataType: "json",
            success: function (data) {
                alert("Form data saved successfully!");
            },
            error: function (error) {
                alert("Error saving form data.");
            }
        });
    }
</script>
</body>
</html>