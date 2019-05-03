import { CreditManagementEnum } from "./creditManagementEnum";

export class RiskEnum {

  static A = CreditManagementEnum.of('A', '0');
  static B = CreditManagementEnum.of('B', '10');
  static C = CreditManagementEnum.of('C', '20');

  static values = [ RiskEnum.A, RiskEnum.B, RiskEnum.C ];

}
