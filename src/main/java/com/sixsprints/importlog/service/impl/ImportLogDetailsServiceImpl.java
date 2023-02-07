package com.sixsprints.importlog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sixsprints.core.domain.ImportLogDetails;
import com.sixsprints.core.dto.ImportLogDetailsDto;
import com.sixsprints.core.dto.MetaData;
import com.sixsprints.core.service.AbstractCrudService;
import com.sixsprints.core.service.ImportLogDetailsService;
import com.sixsprints.importlog.data.ImportLogDetailsFieldData;
import com.sixsprints.importlog.repository.ImportLogDetailsRepository;

@Service
public class ImportLogDetailsServiceImpl extends AbstractCrudService<ImportLogDetails>
  implements ImportLogDetailsService {

  @Autowired
  private ImportLogDetailsRepository importLogDetailsRepository;

  @Override
  protected ImportLogDetailsRepository repository() {
    return importLogDetailsRepository;
  }

  @Override
  protected MetaData<ImportLogDetails> metaData() {
    return MetaData.<ImportLogDetails>builder()
      .classType(ImportLogDetails.class)
      .crudDtoClassType(ImportLogDetailsDto.class)
      .fields(ImportLogDetailsFieldData.fields())
      .build();
  }

  @Override
  protected ImportLogDetails findDuplicate(ImportLogDetails introScreen) {
    return importLogDetailsRepository.findBySlug(introScreen.getSlug());
  }

}
