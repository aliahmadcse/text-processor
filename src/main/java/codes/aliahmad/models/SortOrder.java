package codes.aliahmad.models;

public enum SortOrder
{
  ASC("asc"),
  DESC("desc");

  private final String sortOrder;

  private SortOrder(String sortOrder)
  {
    this.sortOrder = sortOrder;
  }

  public String getSortOrder()
  {
    return sortOrder;
  }
}
