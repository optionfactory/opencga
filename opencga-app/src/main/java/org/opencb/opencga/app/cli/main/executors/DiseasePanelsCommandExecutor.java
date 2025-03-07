package org.opencb.opencga.app.cli.main.executors;

import com.fasterxml.jackson.databind.DeserializationFeature;
import org.opencb.opencga.app.cli.main.executors.OpencgaCommandExecutor;
import org.opencb.opencga.app.cli.main.*;
import org.opencb.opencga.core.response.RestResponse;
import org.opencb.opencga.client.exceptions.ClientException;
import org.opencb.commons.datastore.core.ObjectMap;

import org.opencb.opencga.catalog.exceptions.CatalogAuthenticationException;
import org.opencb.opencga.core.common.JacksonUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.HashMap;
import org.opencb.opencga.core.response.QueryType;
import org.opencb.commons.utils.PrintUtils;

import org.opencb.opencga.app.cli.main.options.DiseasePanelsCommandOptions;

import org.opencb.biodata.models.clinical.interpretation.DiseasePanel;
import org.opencb.opencga.catalog.utils.ParamUtils.AclAction;
import org.opencb.opencga.core.models.job.Job;
import org.opencb.opencga.core.models.panel.Panel;
import org.opencb.opencga.core.models.panel.PanelAclEntryList;
import org.opencb.opencga.core.models.panel.PanelAclUpdateParams;
import org.opencb.opencga.core.models.panel.PanelCreateParams;
import org.opencb.opencga.core.models.panel.PanelImportParams;
import org.opencb.opencga.core.models.panel.PanelUpdateParams;


/*
* WARNING: AUTOGENERATED CODE
*
* This code was generated by a tool.
*
* Manual changes to this file may cause unexpected behavior in your application.
* Manual changes to this file will be overwritten if the code is regenerated.
*  
*/
/**
 * This class contains methods for the Disease Panels command line.
 *    PATH: /{apiVersion}/panels
 */
public class DiseasePanelsCommandExecutor extends OpencgaCommandExecutor {

    public DiseasePanelsCommandOptions diseasePanelsCommandOptions;

    public DiseasePanelsCommandExecutor(DiseasePanelsCommandOptions diseasePanelsCommandOptions) throws CatalogAuthenticationException {
        super(diseasePanelsCommandOptions.commonCommandOptions);
        this.diseasePanelsCommandOptions = diseasePanelsCommandOptions;
    }

    @Override
    public void execute() throws Exception {

        logger.debug("Executing Disease Panels command line");

        String subCommandString = getParsedSubCommand(diseasePanelsCommandOptions.jCommander);

        RestResponse queryResponse = null;

        switch (subCommandString) {
            case "acl-update":
                queryResponse = updateAcl();
                break;
            case "create":
                queryResponse = create();
                break;
            case "distinct":
                queryResponse = distinct();
                break;
            case "import":
                queryResponse = importPanels();
                break;
            case "search":
                queryResponse = search();
                break;
            case "acl":
                queryResponse = acl();
                break;
            case "delete":
                queryResponse = delete();
                break;
            case "info":
                queryResponse = info();
                break;
            case "update":
                queryResponse = update();
                break;
            default:
                logger.error("Subcommand not valid");
                break;
        }

        createOutput(queryResponse);

    }

    private RestResponse<PanelAclEntryList> updateAcl() throws Exception {
        logger.debug("Executing updateAcl in Disease Panels command line");

        DiseasePanelsCommandOptions.UpdateAclCommandOptions commandOptions = diseasePanelsCommandOptions.updateAclCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }


        PanelAclUpdateParams panelAclUpdateParams = null;
        if (commandOptions.jsonDataModel) {
            panelAclUpdateParams = new PanelAclUpdateParams();
            RestResponse<PanelAclEntryList> res = new RestResponse<>();
            res.setType(QueryType.VOID);
            PrintUtils.println(getObjectAsJSON(panelAclUpdateParams));
            return res;
        } else if (commandOptions.jsonFile != null) {
            panelAclUpdateParams = JacksonUtils.getDefaultObjectMapper()
                    .readValue(new java.io.File(commandOptions.jsonFile), PanelAclUpdateParams.class);
        } else {
            ObjectMap beanParams = new ObjectMap();
            putNestedIfNotEmpty(beanParams, "permissions",commandOptions.permissions, true);
            putNestedIfNotEmpty(beanParams, "panel",commandOptions.panel, true);

            panelAclUpdateParams = JacksonUtils.getDefaultObjectMapper().copy()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true)
                    .readValue(beanParams.toJson(), PanelAclUpdateParams.class);
        }
        return openCGAClient.getDiseasePanelClient().updateAcl(commandOptions.members, commandOptions.action, panelAclUpdateParams, queryParams);
    }

    private RestResponse<Panel> create() throws Exception {
        logger.debug("Executing create in Disease Panels command line");

        DiseasePanelsCommandOptions.CreateCommandOptions commandOptions = diseasePanelsCommandOptions.createCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("include", commandOptions.include);
        queryParams.putIfNotEmpty("exclude", commandOptions.exclude);
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotNull("includeResult", commandOptions.includeResult);
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }


        PanelCreateParams panelCreateParams = null;
        if (commandOptions.jsonDataModel) {
            panelCreateParams = new PanelCreateParams();
            RestResponse<Panel> res = new RestResponse<>();
            res.setType(QueryType.VOID);
            PrintUtils.println(getObjectAsJSON(panelCreateParams));
            return res;
        } else if (commandOptions.jsonFile != null) {
            panelCreateParams = JacksonUtils.getDefaultObjectMapper()
                    .readValue(new java.io.File(commandOptions.jsonFile), PanelCreateParams.class);
        } else {
            ObjectMap beanParams = new ObjectMap();
            putNestedIfNotEmpty(beanParams, "id",commandOptions.id, true);
            putNestedIfNotEmpty(beanParams, "name",commandOptions.name, true);
            putNestedIfNotEmpty(beanParams, "description",commandOptions.description, true);
            putNestedIfNotEmpty(beanParams, "author",commandOptions.author, true);
            putNestedIfNotEmpty(beanParams, "source.id",commandOptions.sourceId, true);
            putNestedIfNotEmpty(beanParams, "source.name",commandOptions.sourceName, true);
            putNestedIfNotEmpty(beanParams, "source.version",commandOptions.sourceVersion, true);
            putNestedIfNotEmpty(beanParams, "source.author",commandOptions.sourceAuthor, true);
            putNestedIfNotEmpty(beanParams, "source.project",commandOptions.sourceProject, true);
            putNestedIfNotNull(beanParams, "tags",commandOptions.tags, true);
            putNestedIfNotNull(beanParams, "attributes",commandOptions.attributes, true);

            panelCreateParams = JacksonUtils.getDefaultObjectMapper().copy()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true)
                    .readValue(beanParams.toJson(), PanelCreateParams.class);
        }
        return openCGAClient.getDiseasePanelClient().create(panelCreateParams, queryParams);
    }

    private RestResponse<Object> distinct() throws Exception {
        logger.debug("Executing distinct in Disease Panels command line");

        DiseasePanelsCommandOptions.DistinctCommandOptions commandOptions = diseasePanelsCommandOptions.distinctCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotEmpty("id", commandOptions.id);
        queryParams.putIfNotEmpty("uuid", commandOptions.uuid);
        queryParams.putIfNotEmpty("name", commandOptions.name);
        queryParams.putIfNotEmpty("internalStatus", commandOptions.internalStatus);
        queryParams.putIfNotEmpty("disorders", commandOptions.disorders);
        queryParams.putIfNotEmpty("variants", commandOptions.variants);
        queryParams.putIfNotEmpty("genes", commandOptions.genes);
        queryParams.putIfNotEmpty("source", commandOptions.source);
        queryParams.putIfNotEmpty("regions", commandOptions.regions);
        queryParams.putIfNotEmpty("categories", commandOptions.categories);
        queryParams.putIfNotEmpty("tags", commandOptions.tags);
        queryParams.putIfNotNull("deleted", commandOptions.deleted);
        queryParams.putIfNotEmpty("status", commandOptions.status);
        queryParams.putIfNotEmpty("creationDate", commandOptions.creationDate);
        queryParams.putIfNotEmpty("modificationDate", commandOptions.modificationDate);
        queryParams.putIfNotEmpty("acl", commandOptions.acl);
        queryParams.putIfNotEmpty("release", commandOptions.release);
        queryParams.putIfNotNull("snapshot", commandOptions.snapshot);
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getDiseasePanelClient().distinct(commandOptions.field, queryParams);
    }

    private RestResponse<Job> importPanels() throws Exception {
        logger.debug("Executing import in Disease Panels command line");

        DiseasePanelsCommandOptions.ImportCommandOptions commandOptions = diseasePanelsCommandOptions.importCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotEmpty("jobId", commandOptions.jobId);
        queryParams.putIfNotEmpty("jobDependsOn", commandOptions.jobDependsOn);
        queryParams.putIfNotEmpty("jobDescription", commandOptions.jobDescription);
        queryParams.putIfNotEmpty("jobTags", commandOptions.jobTags);
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }


        PanelImportParams panelImportParams = null;
        if (commandOptions.jsonDataModel) {
            panelImportParams = new PanelImportParams();
            RestResponse<Job> res = new RestResponse<>();
            res.setType(QueryType.VOID);
            PrintUtils.println(getObjectAsJSON(panelImportParams));
            return res;
        } else if (commandOptions.jsonFile != null) {
            panelImportParams = JacksonUtils.getDefaultObjectMapper()
                    .readValue(new java.io.File(commandOptions.jsonFile), PanelImportParams.class);
        } else {
            ObjectMap beanParams = new ObjectMap();
            putNestedIfNotEmpty(beanParams, "source",commandOptions.source, true);
            putNestedIfNotEmpty(beanParams, "id",commandOptions.id, true);

            panelImportParams = JacksonUtils.getDefaultObjectMapper().copy()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true)
                    .readValue(beanParams.toJson(), PanelImportParams.class);
        }
        return openCGAClient.getDiseasePanelClient().importPanels(panelImportParams, queryParams);
    }

    private RestResponse<Panel> search() throws Exception {
        logger.debug("Executing search in Disease Panels command line");

        DiseasePanelsCommandOptions.SearchCommandOptions commandOptions = diseasePanelsCommandOptions.searchCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("include", commandOptions.include);
        queryParams.putIfNotEmpty("exclude", commandOptions.exclude);
        queryParams.putIfNotNull("limit", commandOptions.limit);
        queryParams.putIfNotNull("skip", commandOptions.skip);
        queryParams.putIfNotNull("count", commandOptions.count);
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotEmpty("id", commandOptions.id);
        queryParams.putIfNotEmpty("uuid", commandOptions.uuid);
        queryParams.putIfNotEmpty("name", commandOptions.name);
        queryParams.putIfNotEmpty("internalStatus", commandOptions.internalStatus);
        queryParams.putIfNotEmpty("disorders", commandOptions.disorders);
        queryParams.putIfNotEmpty("variants", commandOptions.variants);
        queryParams.putIfNotEmpty("genes", commandOptions.genes);
        queryParams.putIfNotEmpty("source", commandOptions.source);
        queryParams.putIfNotEmpty("regions", commandOptions.regions);
        queryParams.putIfNotEmpty("categories", commandOptions.categories);
        queryParams.putIfNotEmpty("tags", commandOptions.tags);
        queryParams.putIfNotNull("deleted", commandOptions.deleted);
        queryParams.putIfNotEmpty("status", commandOptions.status);
        queryParams.putIfNotEmpty("creationDate", commandOptions.creationDate);
        queryParams.putIfNotEmpty("modificationDate", commandOptions.modificationDate);
        queryParams.putIfNotEmpty("acl", commandOptions.acl);
        queryParams.putIfNotEmpty("release", commandOptions.release);
        queryParams.putIfNotNull("snapshot", commandOptions.snapshot);
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getDiseasePanelClient().search(queryParams);
    }

    private RestResponse<PanelAclEntryList> acl() throws Exception {
        logger.debug("Executing acl in Disease Panels command line");

        DiseasePanelsCommandOptions.AclCommandOptions commandOptions = diseasePanelsCommandOptions.aclCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotEmpty("member", commandOptions.member);
        queryParams.putIfNotNull("silent", commandOptions.silent);
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getDiseasePanelClient().acl(commandOptions.panels, queryParams);
    }

    private RestResponse<Panel> delete() throws Exception {
        logger.debug("Executing delete in Disease Panels command line");

        DiseasePanelsCommandOptions.DeleteCommandOptions commandOptions = diseasePanelsCommandOptions.deleteCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getDiseasePanelClient().delete(commandOptions.panels, queryParams);
    }

    private RestResponse<Panel> info() throws Exception {
        logger.debug("Executing info in Disease Panels command line");

        DiseasePanelsCommandOptions.InfoCommandOptions commandOptions = diseasePanelsCommandOptions.infoCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("include", commandOptions.include);
        queryParams.putIfNotEmpty("exclude", commandOptions.exclude);
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotEmpty("version", commandOptions.version);
        queryParams.putIfNotNull("deleted", commandOptions.deleted);
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getDiseasePanelClient().info(commandOptions.panels, queryParams);
    }

    private RestResponse<Panel> update() throws Exception {
        logger.debug("Executing update in Disease Panels command line");

        DiseasePanelsCommandOptions.UpdateCommandOptions commandOptions = diseasePanelsCommandOptions.updateCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("include", commandOptions.include);
        queryParams.putIfNotEmpty("exclude", commandOptions.exclude);
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotNull("includeResult", commandOptions.includeResult);
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }


        PanelUpdateParams panelUpdateParams = null;
        if (commandOptions.jsonDataModel) {
            panelUpdateParams = new PanelUpdateParams();
            RestResponse<Panel> res = new RestResponse<>();
            res.setType(QueryType.VOID);
            PrintUtils.println(getObjectAsJSON(panelUpdateParams));
            return res;
        } else if (commandOptions.jsonFile != null) {
            panelUpdateParams = JacksonUtils.getDefaultObjectMapper()
                    .readValue(new java.io.File(commandOptions.jsonFile), PanelUpdateParams.class);
        } else {
            ObjectMap beanParams = new ObjectMap();
            putNestedIfNotEmpty(beanParams, "id",commandOptions.id, true);
            putNestedIfNotEmpty(beanParams, "name",commandOptions.name, true);
            putNestedIfNotEmpty(beanParams, "description",commandOptions.description, true);
            putNestedIfNotEmpty(beanParams, "author",commandOptions.author, true);
            putNestedIfNotEmpty(beanParams, "source.id",commandOptions.sourceId, true);
            putNestedIfNotEmpty(beanParams, "source.name",commandOptions.sourceName, true);
            putNestedIfNotEmpty(beanParams, "source.version",commandOptions.sourceVersion, true);
            putNestedIfNotEmpty(beanParams, "source.author",commandOptions.sourceAuthor, true);
            putNestedIfNotEmpty(beanParams, "source.project",commandOptions.sourceProject, true);
            putNestedIfNotNull(beanParams, "tags",commandOptions.tags, true);
            putNestedIfNotNull(beanParams, "attributes",commandOptions.attributes, true);

            panelUpdateParams = JacksonUtils.getDefaultObjectMapper().copy()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true)
                    .readValue(beanParams.toJson(), PanelUpdateParams.class);
        }
        return openCGAClient.getDiseasePanelClient().update(commandOptions.panels, panelUpdateParams, queryParams);
    }
}