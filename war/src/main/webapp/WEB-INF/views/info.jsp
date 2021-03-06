<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ru.korus.tmis.pdm.ws.PdmSysProperties" %>
<%@ page import="ru.korus.tmis.pdm.alee.AleeCode" %>
<%@ page import="ru.korus.tmis.pdm.alee.AleePdmOperations" %>
<%@ page import="java.util.Map" %>
<%@ page import="ru.korus.tmis.pdm.ws.hl7.PostalAddressUse" %>
<%@ page import="ru.korus.tmis.pdm.ws.hl7.TelecommunicationAddressUse" %>
<%@ page import="ch.qos.logback.core.util.StatusPrinter" %>
<%@ page import="ch.qos.logback.classic.LoggerContext" %>
<%@ page import="org.slf4j.LoggerFactory" %>
<%@ page import="java.io.PrintStream" %>
<%@ page import="java.io.ByteArrayOutputStream" %>
<%@ page import="java.io.OutputStream" %>
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
        <TD><%=String.format("%s", AleePdmOperations.getConfig().getGivenCode()) %>
        </TD>
    </TR>
    <TR>
        <TD>Отчество</TD>
        <TD><%=String.format("%s", AleePdmOperations.getConfig().getMiddleNameCode())%>
        </TD>
    </TR>

    <TR>
        <TD>Фамилия</TD>
        <TD><%=String.format("%s", AleePdmOperations.getConfig().getFamilyCode())%>
        </TD>
    </TR>
    <TR>
        <TD>Пол</TD>
        <TD><%=String.format("%s", AleePdmOperations.getConfig().getGenderCode())%>
        </TD>
    </TR>
    <TR>
        <TD>Дата рождения</TD>
        <TD><%=String.format("%s", AleePdmOperations.getConfig().getBirthDataCode())%>
        </TD>
    </TR>
    <TR>
        <TD>Место рождения</TD>
        <TD><%=String.format("%s", AleePdmOperations.getConfig().getBirthPlaceCode())%>
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
<h3>Supported Address Type</h3>
<table border="1">
    <TR>
        <TH>HL7 use code</TH>
        <TH>Alee code</TH>
    </TR>
    <% for (Map.Entry<PostalAddressUse, String> addrCode : AleePdmOperations.getConfig().getAddrMap().entrySet()) { %>
    <TR>
        <TD><%=addrCode.getKey()%>
        </TD>
        <TD><%=addrCode.getValue()%>
        </TD>
    </TR>
    <%}%>
</table>
<h3>Supported Telecoms Type</h3>
<table border="1">
    <TR>
        <TH>HL7 use code</TH>
        <TH>Alee code</TH>
    </TR>
    <% for (Map.Entry<TelecommunicationAddressUse, String> telCode : AleePdmOperations.getConfig().getTelecomMap().entrySet()) { %>
    <TR>
        <TD><%=telCode.getKey()%>
        </TD>
        <TD><%=telCode.getValue()%>
        </TD>
    </TR>
    <%}%>
</table>

<h3>The dump of config file:</h3>
<textarea rows="30" cols="70" readonly="readonly"><%=AleePdmOperations.getConfigDump()%>/></textarea>

<h3>logback info</h3>
<% final ByteArrayOutputStream outLog = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(outLog);
    StatusPrinter.setPrintStream(ps);
    StatusPrinter.print((LoggerContext) LoggerFactory.getILoggerFactory());
    String logInfo[] = outLog.toString("UTF-8").split("\n");
    for (String curInfo : logInfo) {%>
<textarea rows="30" cols="150" readonly="readonly"><%=outLog.toString("UTF-8")%>
</textarea>
<%}%>
</body>
</html>