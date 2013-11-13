<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ru.korus.tmis.pdm.PdmSysProperties" %>
<%@ page import="ru.korus.tmis.pdm.alee.AleeCode" %>
<%@ page import="ru.korus.tmis.pdm.alee.AleePdmOperations" %>
<%@ page import="java.util.Map" %>
<html>
<head>
    <title>PDM info</title>
</head>
<body>

<h2>JVM settings (or default value if the option is not set):</h2>
<table border="1">
    <TR>
        <TH>options</TH>
        <TH>value</TH>
    </TR>
    <TR>
        <TD><%=PdmSysProperties.PDM_STORAGE_TYPE%>
        </TD>
        <TD><%=PdmSysProperties.getPdmStorageType()%>
        </TD>
    </TR>
    <TR>
        <TD><%=PdmSysProperties.PDM_CONFIG_FILE%>
        </TD>
        <TD><%=PdmSysProperties.getConfigFileName()%>
        </TD>
    </TR>
    <TR>
        <TD><%=PdmSysProperties.PDM_ALEE_URL%>
        </TD>
        <TD><%=PdmSysProperties.getAleeUrl()%>
        </TD>
    </TR>
</table>

<h2>Alee attributes and OID:</h2>

<h3>Standard attributes:</h3>
<table border="1">
    <TR>
        <TH>Attribute</TH>
        <TH>Alee code</TH>
    </TR>
    <TR>
        <TD>Имя</TD>
        <TD><%=AleePdmOperations.getConfig().getGivenCode() %>
        </TD>
    </TR>
    <TR>
        <TD>Отчество</TD>
        <TD><%=AleePdmOperations.getConfig().getMiddleNameCode()%>
        </TD>
    </TR>

    <TR>
        <TD>Фамилия</TD>
        <TD><%=AleePdmOperations.getConfig().getFamilyCode()%>
        </TD>
    </TR>
    <TR>
        <TD>Пол</TD>
        <TD><%=AleePdmOperations.getConfig().getGenderCode()%>
        </TD>
    </TR>
    <TR>
        <TD>Дата рождения</TD>
        <TD><%=AleePdmOperations.getConfig().getBirthDataCode()%>
        </TD>
    </TR>
    <TR>
        <TD>Место рождения</TD>
        <TD><%=AleePdmOperations.getConfig().getBirthPlaceCode()%>
        </TD>
    </TR>
    <TR>
        <TD>e-mail</TD>
        <TD><%=String.format("%s", AleePdmOperations.getConfig().getEmailCode())%>
        </TD>
    </TR>
</table>
<h3>Standard documents:</h3>
<table border="1">
    <TR>
        <TH>Description</TH>
        <TH>OID (for HL7)</TH>
        <TH>Alee code</TH>
    </TR>
    <% for (Map.Entry<String, AleeCode> docCode : AleePdmOperations.getConfig().getDocsMap().entrySet()) { %>
    <TR>
        <TD><%=docCode.getValue().getDescription()%>
        </TD>
        <TD><%=docCode.getKey()%>
        </TD>
        <TD><%=docCode.getValue().getCode()%>
        </TD>
    </TR>
    <%}%>
</table>
</body>
</html>