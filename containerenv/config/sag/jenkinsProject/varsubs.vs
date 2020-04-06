<?xml version="1.0" encoding="UTF-8"?><Root>
  <DeploymentSet allowEmptyValues="false" assetCompositeName="simpleOrderConnection" deploymentSetName="myDeploymentSet" serverAliasName="PipelienPRJ" targetServerName="testServer" targetServerType="IS">
    <Property propertyName="activatePkgOnInstall" propertyValue="true"/>
    <Property propertyName="archivePkgOnInstall" propertyValue="true"/>
    <Property propertyName="compilePackage" propertyValue="true"/>
    <Property propertyName="fragPackage" propertyValue="true"/>
    <Property propertyName="clearACLs" propertyValue="false"/>
    <Property propertyName="disallowActivePackageInstall" propertyValue="false"/>
    <Property propertyName="packageExecutionCheck" propertyValue="0"/>
    <Property propertyName="suspendTriggersDuringDeploy" propertyValue="false"/>
    <Property propertyName="syncDocTypesToBroker" propertyValue="true"/>
    <Component name="simpleOrderConnection.simpleOrderConnection" type="artconnection">
      <Property propertyName="art.deployment.state" propertyValue="enable"/>
      <Property propertyName="transactionType" propertyValue="NO_TRANSACTION"/>
      <Property propertyName="datasourceClass" propertyValue="oracle.jdbc.pool.OracleDataSource"/>
      <Property propertyName="serverName" propertyValue="localhost"/>
      <Property propertyName="user" propertyValue="webm"/>
      <Property propertyName="password" propertyValue="manage"/>
      <Property propertyName="databaseName" propertyValue="webmdb"/>
      <Property propertyName="portNumber" propertyValue="1521"/>
      <Property propertyName="networkProtocol" propertyValue="TCP"/>
      <Property propertyName="otherProperties" propertyValue="url=jdbc:oracle:thin:@//localhost:1521/xe"/>
      <Property propertyName=".CMGRPROP.poolable" propertyValue="true"/>
      <Property propertyName=".CMGRPROP.minimumPoolSize" propertyValue="1"/>
      <Property propertyName=".CMGRPROP.maximumPoolSize" propertyValue="10"/>
      <Property propertyName=".CMGRPROP.poolIncrementSize" propertyValue="1"/>
      <Property propertyName=".CMGRPROP.blockingTimeout" propertyValue="1000"/>
      <Property propertyName=".CMGRPROP.expireTimeout" propertyValue="1000"/>
      <Property propertyName=".CMGRPROP.startupRetryCount" propertyValue="0"/>
      <Property propertyName=".CMGRPROP.startupBackoffSecs" propertyValue="10"/>
    </Component>
  </DeploymentSet>
</Root>