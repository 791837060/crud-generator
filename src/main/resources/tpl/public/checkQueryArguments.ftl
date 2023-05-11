        Preconditions.checkArgument(query != null, "query condition is empty");
        Preconditions.checkArgument(query.getPageNo() != null && query.getPageNo() > 0, "Page number must be greater than 0");
        Preconditions.checkArgument(query.getPageSize() != null && query.getPageSize() > 0, "Paging size must be greater than 0");
