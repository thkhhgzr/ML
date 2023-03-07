numeric_features = ["year"]
numeric_transformer = make_pipeline(SimpleImputer(strategy="median"))
categorical_features = ["month", "brigade"]

preprocessor = ColumnTransformer(
    [
        ("num", numeric_transformer, numeric_features),
        (
            "cat",
            OneHotEncoder(handle_unknown="ignore", sparse_output=False),
            categorical_features,
        ),
    ],
    verbose_feature_names_out=False,
)

pipe = Pipeline(steps=[
    ('pre', preprocessor),
   ('scl', StandardScaler()),
   ('clf', LogisticRegression(max_iter=10000))])

parameters = {'clf__C':[0.01, 0.1, 1]}

log_reg = GridSearchCV(pipe, parameters)