/*
* Copyright 2015-2023-04-18 OpenCB
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package org.opencb.opencga.app.cli.main;

import org.jline.reader.Candidate;
import org.jline.reader.Completer;
import org.jline.reader.LineReader;
import org.jline.reader.ParsedLine;
import org.apache.commons.lang3.StringUtils;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;


/*
* WARNING: AUTOGENERATED CODE
*
* This code was generated by a tool.
*
* Manual changes to this file may cause unexpected behavior in your application.
* Manual changes to this file will be overwritten if the code is regenerated.
*  
*/

public abstract class OpenCgaCompleter implements Completer {

    protected List<Candidate> commands = asList("login","logout","help","use","variant","projects","panels","clinical","jobs","admin","individuals","families","users","samples","alignments","meta","studies","files","operations","cohorts")
            .stream()
            .map(Candidate::new)
            .collect(toList());

    private List<Candidate> variantList = asList( "aggregationstats","annotation-metadata","annotation-query","circos-run","cohort-stats-delete","cohort-stats-info","cohort-stats-run","exomiser-run","export-run","family-genotypes","family-qc-run","file-delete","gatk-run","genome-plot-run","gwas-run","hr-detect-run","index-run","individual-qc-run","inferred-sex-run","knockout-gene-query","knockout-individual-query","knockout-run","mendelian-error-run","metadata","mutational-signature-query","mutational-signature-run","plink-run","query","relatedness-run","rvtests-run","sample-aggregation-stats","sample-eligibility-run","sample-qc-run","sample-query","sample-run","sample-stats-query","sample-stats-run","stats-export-run","stats-run")
            .stream()
            .map(Candidate::new)
            .collect(toList());

    private List<Candidate> projectsList = asList( "create","search","aggregationstats","info","increlease","studies","update")
            .stream()
            .map(Candidate::new)
            .collect(toList());

    private List<Candidate> panelsList = asList( "acl-update","create","distinct","import","search","acl","delete","info","update")
            .stream()
            .map(Candidate::new)
            .collect(toList());

    private List<Candidate> clinicalList = asList( "acl-update","clinical-configuration-update","create","distinct","interpretation-distinct","interpretation-search","interpretation-info","interpreter-cancer-tiering-run","interpreter-exomiser-run","interpreter-team-run","interpreter-tiering-run","interpreter-zetta-run","rga-aggregation-stats","rga-gene-query","rga-gene-summary","rga-index-run","rga-individual-query","rga-individual-summary","rga-variant-query","rga-variant-summary","search","variant-query","acl","delete","update","info","interpretation-create","interpretation-clear","interpretation-delete","interpretation-revert","interpretation-update")
            .stream()
            .map(Candidate::new)
            .collect(toList());

    private List<Candidate> jobsList = asList( "acl-update","aggregationstats","create","distinct","retry","search","top","acl","delete","info","update","log-head","log-tail")
            .stream()
            .map(Candidate::new)
            .collect(toList());

    private List<Candidate> adminList = asList( "audit-group-by","catalog-index-stats","catalog-install","catalog-jwt","users-create","users-import","users-search","users-sync")
            .stream()
            .map(Candidate::new)
            .collect(toList());

    private List<Candidate> individualsList = asList( "acl-update","aggregationstats","annotation-sets-load","create","distinct","search","acl","delete","info","update","annotation-sets-annotations-update","relatives")
            .stream()
            .map(Candidate::new)
            .collect(toList());

    private List<Candidate> familiesList = asList( "acl-update","aggregationstats","annotation-sets-load","create","distinct","search","acl","delete","info","update","annotation-sets-annotations-update")
            .stream()
            .map(Candidate::new)
            .collect(toList());

    private List<Candidate> usersList = asList( "login","password","info","configs","configs-update","filters","password-reset","projects","update")
            .stream()
            .map(Candidate::new)
            .collect(toList());

    private List<Candidate> samplesList = asList( "acl-update","aggregationstats","annotation-sets-load","create","distinct","load","search","acl","delete","info","update","annotation-sets-annotations-update")
            .stream()
            .map(Candidate::new)
            .collect(toList());

    private List<Candidate> alignmentsList = asList( "bwa-run","coverage-index-run","coverage-qc-genecoveragestats-run","coverage-query","coverage-ratio","coverage-stats","deeptools-run","fastqc-run","index-run","picard-run","qc-run","query","samtools-run")
            .stream()
            .map(Candidate::new)
            .collect(toList());

    private List<Candidate> metaList = asList( "about","api","fail","model","ping","status")
            .stream()
            .map(Candidate::new)
            .collect(toList());

    private List<Candidate> studiesList = asList( "acl-update","create","search","acl","aggregationstats","info","audit-search","groups","groups-update","groups-users-update","permissionrules","permission-rules-update","templates-run","templates-upload","templates-delete","update","variablesets","variable-sets-update","variable-sets-variables-update")
            .stream()
            .map(Candidate::new)
            .collect(toList());

    private List<Candidate> filesList = asList( "acl-update","aggregationstats","annotation-sets-load","bioformats","create","distinct","fetch","formats","link","link-run","postlink-run","search","upload","acl","delete","info","unlink","update","annotation-sets-annotations-update","download","grep","head","image","refresh","tail","list","tree")
            .stream()
            .map(Candidate::new)
            .collect(toList());

    private List<Candidate> operationsList = asList( "cellbase-configure","variant-aggregate","variant-annotation-delete","variant-annotation-index","variant-annotation-save","variant-configure","variant-delete","variant-family-aggregate","variant-family-index","variant-index","variant-index-launcher","variant-julie-run","variant-metadata-repair","variant-metadata-synchronize","variant-prune","variant-sample-delete","variant-sample-index","variant-sample-index-configure","variant-score-delete","variant-score-index","variant-secondary-annotation-index","variant-secondary-sample-index","configure-variant-secondary-sample-index","variant-secondary-index","variant-secondary-index-delete","variant-stats-delete","variant-stats-index","variant-study-delete")
            .stream()
            .map(Candidate::new)
            .collect(toList());

    private List<Candidate> cohortsList = asList( "acl-update","aggregationstats","annotation-sets-load","create","distinct","generate","search","acl","delete","info","update","annotation-sets-annotations-update")
            .stream()
            .map(Candidate::new)
            .collect(toList());

    @Override
    public void complete(LineReader lineReader, ParsedLine parsedLine, List<Candidate> candidates) {
        String command = parsedLine.line().trim();
        if (StringUtils.isEmpty(command)) {
            candidates.addAll(commands);
            return;
        }
        Map<String, List<Candidate>> mapCandidates=new HashMap();
        mapCandidates.put( "variant", variantList);
        mapCandidates.put( "projects", projectsList);
        mapCandidates.put( "panels", panelsList);
        mapCandidates.put( "clinical", clinicalList);
        mapCandidates.put( "jobs", jobsList);
        mapCandidates.put( "admin", adminList);
        mapCandidates.put( "individuals", individualsList);
        mapCandidates.put( "families", familiesList);
        mapCandidates.put( "users", usersList);
        mapCandidates.put( "samples", samplesList);
        mapCandidates.put( "alignments", alignmentsList);
        mapCandidates.put( "meta", metaList);
        mapCandidates.put( "studies", studiesList);
        mapCandidates.put( "files", filesList);
        mapCandidates.put( "operations", operationsList);
        mapCandidates.put( "cohorts", cohortsList);
         candidates.addAll(checkCandidates(mapCandidates,command)); 
     }
    public abstract List<Candidate> checkCandidates(Map<String, List<Candidate>> candidatesMap,String line);    
}