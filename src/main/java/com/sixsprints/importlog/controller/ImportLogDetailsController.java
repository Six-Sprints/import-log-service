package com.sixsprints.importlog.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sixsprints.core.controller.AbstractImportLogDetailsController;
import com.sixsprints.core.dto.FieldDto;
import com.sixsprints.core.service.ImportLogDetailsService;
import com.sixsprints.core.utils.RestResponse;
import com.sixsprints.core.utils.RestUtil;
import com.sixsprints.importlog.data.ImportLogDetailsFieldData;

@RestController
@RequestMapping("/api/v1/import-log-details")
public class ImportLogDetailsController extends AbstractImportLogDetailsController {

  public ImportLogDetailsController(ImportLogDetailsService service) {
    super(service);
  }

  @Override
  public ResponseEntity<RestResponse<List<FieldDto>>> fields() {
    return RestUtil.successResponse(ImportLogDetailsFieldData.fields());
  }

  @GetMapping("/error/fields")
  public ResponseEntity<RestResponse<List<FieldDto>>> errorFields(Locale locale) {
    return RestUtil.successResponse(ImportLogDetailsFieldData.errorFields());
  }

}
