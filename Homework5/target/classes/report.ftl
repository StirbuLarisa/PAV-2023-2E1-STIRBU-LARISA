<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Catalog Report</title>
</head>
<body>
    <h1>Catalog Report</h1>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Path</th>
                <th>Tags</th>
            </tr>
        </thead>
        <tbody>
            <#list catalog.documents as doc>
                <tr>
                    <td>${doc.id}</td>
                    <td>${doc.name}</td>
                    <td>${doc.path}</td>
                    <td>
                        <ul>
                            <#list doc.tags?keys as key>
                                <li>${key}: ${doc.tags[key]}</li>
                            </#list>
                        </ul>
                    </td>
                </tr>
            </#list>
        </tbody>
    </table>
</body>
</html>
