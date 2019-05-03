export class CreditManagementEnum {
  id: string;
  descricao: string;
  static of(id: string, descricao?: string): CreditManagementEnum {
      const godEnum = new CreditManagementEnum();
      godEnum.id = id;
      godEnum.descricao = descricao;
      return godEnum;
  }
}
