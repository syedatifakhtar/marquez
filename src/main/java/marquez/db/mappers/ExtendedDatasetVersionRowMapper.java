/*
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

package marquez.db.mappers;

import static marquez.db.Columns.stringOrNull;
import static marquez.db.Columns.timestampOrThrow;
import static marquez.db.Columns.uuidArrayOrThrow;
import static marquez.db.Columns.uuidOrNull;
import static marquez.db.Columns.uuidOrThrow;

import java.sql.ResultSet;
import java.sql.SQLException;
import lombok.NonNull;
import marquez.db.Columns;
import marquez.db.models.ExtendedDatasetVersionRow;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public final class ExtendedDatasetVersionRowMapper implements RowMapper<ExtendedDatasetVersionRow> {
  @Override
  public ExtendedDatasetVersionRow map(
      @NonNull ResultSet results, @NonNull StatementContext context) throws SQLException {
    return new ExtendedDatasetVersionRow(
        uuidOrThrow(results, Columns.ROW_UUID),
        timestampOrThrow(results, Columns.CREATED_AT),
        uuidOrThrow(results, Columns.DATASET_UUID),
        uuidOrThrow(results, Columns.VERSION),
        uuidArrayOrThrow(results, Columns.FIELD_UUIDS),
        uuidOrNull(results, Columns.RUN_UUID),
        stringOrNull(results, Columns.DATASET_NAME),
        stringOrNull(results, Columns.NAMESPACE_NAME));
  }
}
