package com.sixsprints.importlog.data;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import com.google.common.collect.ImmutableMap;
import com.sixsprints.core.dto.FieldDto;
import com.sixsprints.core.enums.DataType;

public class ImportLogDetailsFieldData {

  public static final List<FieldDto> fields() {
    LinkedList<FieldDto> fields = new LinkedList<>();
    int i = 0;

    fields.add(FieldDto.builder().name("slug").displayName("ID").sequence(i++)
      .dataType(DataType.TEXT).isLocked(true)
      .localizedDisplay(ImmutableMap.<Locale, String>of(Locale.ENGLISH, "ID", Locale.JAPANESE, "ID"))
      .build());

    fields.add(FieldDto.builder().name("dateCreated").displayName("Date").sequence(i++)
      .dataType(DataType.DATE).isLocked(true)
      .localizedDisplay(ImmutableMap.<Locale, String>of(Locale.ENGLISH, "Date", Locale.JAPANESE, "処理日時"))
      .build());

    fields.add(FieldDto.builder().name("createdBy").displayName("User ID").sequence(i++)
      .dataType(DataType.TEXT).isLocked(true)
      .localizedDisplay(ImmutableMap.<Locale, String>of(Locale.ENGLISH, "User ID", Locale.JAPANESE, "ユーザーID"))
      .build());

    fields.add(FieldDto.builder().name("entity").displayName("Entity").sequence(i++)
      .dataType(DataType.TEXT).isLocked(true)
      .localizedDisplay(ImmutableMap.<Locale, String>of(Locale.ENGLISH, "Entity", Locale.JAPANESE, "対象"))
      .build());

    fields.add(FieldDto.builder().name("totalRowCount").displayName("Total Rows").sequence(i++)
      .dataType(DataType.NUMBER).isLocked(true)
      .localizedDisplay(ImmutableMap.<Locale, String>of(Locale.ENGLISH, "Total Rows", Locale.JAPANESE, "行数 合計"))
      .build());

    fields.add(FieldDto.builder().name("successRowCount").displayName("Successful Row Count").sequence(i++)
      .dataType(DataType.NUMBER).isLocked(true)
      .localizedDisplay(ImmutableMap.<Locale, String>of(Locale.ENGLISH, "Successful Row Count", Locale.JAPANESE,
        "処理に成功した行数"))
      .build());

    fields
      .add(
        FieldDto.builder().name("warningRowCount").displayName("Warning Row Count").sequence(i++)
          .dataType(DataType.NUMBER).isLocked(true)
          .localizedDisplay(
            ImmutableMap.<Locale, String>of(Locale.ENGLISH, "Warning Row Count", Locale.JAPANESE, "エラーセル数"))
          .build());

    fields
      .add(FieldDto.builder().name("errorRowCount").displayName("Error Row Count").sequence(i++)
        .dataType(DataType.NUMBER).isLocked(true)
        .localizedDisplay(
          ImmutableMap.<Locale, String>of(Locale.ENGLISH, "Error Row Count", Locale.JAPANESE, "処理に失敗した行数"))
        .build());

    return fields;
  }

  public static final List<FieldDto> errorFields() {
    LinkedList<FieldDto> fields = new LinkedList<>();
    int i = 0;
    fields
      .add(FieldDto.builder().name("cellLocation").displayName("Cell Location").sequence(i++)
        .dataType(DataType.TEXT).isLocked(true)
        .localizedDisplay(
          ImmutableMap.<Locale, String>of(Locale.ENGLISH, "Cell Location", Locale.JAPANESE, "エラーセルの位置情報"))
        .build());

    fields
      .add(FieldDto.builder().name("message").displayName("Error Message").sequence(i++)
        .dataType(DataType.TEXT).isLocked(true)
        .localizedDisplay(
          ImmutableMap.<Locale, String>of(Locale.ENGLISH, "Error Message", Locale.JAPANESE, "エラーメッセージ内容"))
        .build());

    fields
      .add(FieldDto.builder().name("type").displayName("Type").sequence(i++)
        .dataType(DataType.TEXT).isLocked(true)
        .localizedDisplay(
          ImmutableMap.<Locale, String>of(Locale.ENGLISH, "Type", Locale.JAPANESE, "区分"))
        .build());

    return fields;
  }

}
