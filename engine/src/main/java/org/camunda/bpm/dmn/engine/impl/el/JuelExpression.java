/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.bpm.dmn.engine.impl.el;

import javax.el.ELContext;
import javax.el.ValueExpression;

import org.camunda.bpm.dmn.engine.el.ElExpression;
import org.camunda.bpm.engine.variable.VariableContext;

/**
 * @author Daniel Meyer
 *
 */
public class JuelExpression implements ElExpression {

  protected final ValueExpression expression;
  protected final JuelElContextFactory elContextFactory;

  public JuelExpression(ValueExpression expression, JuelElContextFactory elContextFactory) {
    this.expression = expression;
    this.elContextFactory = elContextFactory;
  }

  public Object getValue(VariableContext variableContext) {
    ELContext elContext = elContextFactory.createElContext(variableContext);
    return expression.getValue(elContext);
  }

}