package com.sixsprints.importlog.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sixsprints.core.domain.ImportLogDetails;
import com.sixsprints.core.dto.ImportLogDetailsDto;
import com.sixsprints.core.dto.MetaData;
import com.sixsprints.core.dto.SlugFormatter;
import com.sixsprints.core.service.AbstractCrudService;
import com.sixsprints.core.service.ImportLogDetailsService;
import com.sixsprints.importlog.data.ImportLogDetailsFieldData;
import com.sixsprints.importlog.repository.ImportLogDetailsRepository;

@Service
public class ImportLogDetailsServiceImpl extends AbstractCrudService<ImportLogDetails>
  implements ImportLogDetailsService {

  @Autowired
  private ImportLogDetailsRepository ImportLogDetailsRepository;

  @Override
  protected ImportLogDetailsRepository repository() {
    return ImportLogDetailsRepository;
  }

  @Override
  protected MetaData<ImportLogDetails> metaData() {
    return MetaData.<ImportLogDetails>builder()
      .classType(ImportLogDetails.class)
      .dtoClassType(ImportLogDetailsDto.class)
      .fields(ImportLogDetailsFieldData.fields())
      .build();
  }

  @Override
  protected ImportLogDetails findDuplicate(ImportLogDetails introScreen) {
    return ImportLogDetailsRepository.findBySlug(introScreen.getSlug());
  }

  @Override
  protected void generateSlugIfRequired(ImportLogDetails entity) {
    if (StringUtils.isEmpty(entity.getId())) {
      SlugFormatter slugFromatter = slugFromatter(entity);
      if (slugFromatter != null && slugFromatter.getCollection() != null) {
        Long nextSequence = getNextSequence(slugFromatter.getCollection());
        String slug = "0000000" + nextSequence.toString();
        slug = slugFromatter.getPrefix() + slug.substring(slug.length() - 7);
        entity.setSlug(slug);
        entity.setSequence(nextSequence);
      }
    }
  }

}
